package com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl

import com.example.moviesseriesproject.data.model.tvshow.TvShowList
import com.example.moviesseriesproject.data.api.MoviesSeriesService
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteSourceImpl(
    private val moviesSeriesService: MoviesSeriesService,
    private val apiKey: String,
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> =
        moviesSeriesService.getPopularTvShows(apiKey)
}