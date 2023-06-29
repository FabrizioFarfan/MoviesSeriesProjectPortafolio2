package com.example.moviesseriesproject.domain.repository

import com.example.moviesseriesproject.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}