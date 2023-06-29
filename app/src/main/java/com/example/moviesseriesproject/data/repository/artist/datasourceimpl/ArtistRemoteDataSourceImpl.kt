package com.example.moviesseriesproject.data.repository.artist.datasourceimpl

import com.example.moviesseriesproject.data.model.artist.ArtistList
import com.example.moviesseriesproject.data.api.MoviesSeriesService
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val moviesSeriesService: MoviesSeriesService,
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> =
        moviesSeriesService.getPopularArtists(apiKey)
}