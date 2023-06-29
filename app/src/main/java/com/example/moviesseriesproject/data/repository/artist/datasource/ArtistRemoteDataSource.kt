package com.example.moviesseriesproject.data.repository.artist.datasource

import com.example.moviesseriesproject.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}