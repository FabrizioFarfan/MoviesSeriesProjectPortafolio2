package com.example.moviesseriesproject.ui.di.movie

import com.example.moviesseriesproject.domain.usecase.GetMoviesUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateMoviesUseCase
import com.example.moviesseriesproject.ui.viewmodel.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory =
        MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
}