package com.example.moviesseriesproject.data.repository.movie.datasourceimpl


import com.example.moviesseriesproject.data.model.movie.MovieList
import com.example.moviesseriesproject.data.api.MoviesSeriesService
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val moviesSeriesService: MoviesSeriesService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        moviesSeriesService.getPopularMovies(apiKey)

}