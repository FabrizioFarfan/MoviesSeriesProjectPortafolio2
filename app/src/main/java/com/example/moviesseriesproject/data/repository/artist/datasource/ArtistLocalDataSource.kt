package com.example.moviesseriesproject.data.repository.artist.datasource

import com.example.moviesseriesproject.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()

}