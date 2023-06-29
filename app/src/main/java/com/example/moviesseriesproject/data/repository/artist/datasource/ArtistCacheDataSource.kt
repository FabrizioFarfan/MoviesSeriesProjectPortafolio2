package com.example.moviesseriesproject.data.repository.artist.datasource

import com.example.moviesseriesproject.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}