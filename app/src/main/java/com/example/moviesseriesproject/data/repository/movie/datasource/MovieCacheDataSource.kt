package com.example.moviesseriesproject.data.repository.movie.datasource

import com.example.moviesseriesproject.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}