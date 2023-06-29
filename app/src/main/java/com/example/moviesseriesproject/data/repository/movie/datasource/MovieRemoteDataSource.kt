package com.example.moviesseriesproject.data.repository.movie.datasource

import com.example.moviesseriesproject.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}