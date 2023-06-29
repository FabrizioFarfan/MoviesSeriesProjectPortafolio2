package com.example.moviesseriesproject.domain.usecase

import com.example.moviesseriesproject.data.model.movie.Movie
import com.example.moviesseriesproject.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}