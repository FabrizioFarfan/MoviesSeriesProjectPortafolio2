package com.example.moviesseriesproject.data.repository.artist.datasourceimpl

import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}