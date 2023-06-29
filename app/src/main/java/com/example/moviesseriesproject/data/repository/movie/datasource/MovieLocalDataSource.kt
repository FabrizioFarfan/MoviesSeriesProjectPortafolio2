package com.example.moviesseriesproject.data.repository.movie.datasource

import com.example.moviesseriesproject.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()

}