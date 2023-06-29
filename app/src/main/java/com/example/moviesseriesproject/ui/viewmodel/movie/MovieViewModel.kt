package com.example.moviesseriesproject.ui.viewmodel.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesseriesproject.domain.usecase.GetMoviesUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData{
        val movies = getMoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData{
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }
}