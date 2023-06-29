package com.example.moviesseriesproject.data.repository.artist.datasourceimpl

import com.example.moviesseriesproject.data.db.ArtistDao
import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {

    override suspend fun getArtistFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtists(artists)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}