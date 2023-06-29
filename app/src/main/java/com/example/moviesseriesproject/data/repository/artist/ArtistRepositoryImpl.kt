package com.example.moviesseriesproject.data.repository.artist

import android.util.Log
import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesseriesproject.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {

        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistsToCache(newArtistList)

        return newArtistList
    }


    suspend fun getArtistsFromApi() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) artistList = body.artists
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDatabase() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (artistList.isNotEmpty()) return artistList
            else {
                artistList = getArtistsFromApi()
                artistLocalDataSource.saveArtistsToDB(artistList)
            }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistsList: List<Artist>

        try {
            artistsList = artistCacheDataSource.getArtistFromCache()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (artistsList.isNotEmpty()) return artistsList
            else {
                artistsList = getArtistsFromDatabase()
                artistCacheDataSource.saveArtistsToCache(artistsList)
            }
        return artistsList
    }
}