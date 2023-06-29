package com.example.moviesseriesproject.ui.di.tvshow

import com.example.moviesseriesproject.domain.usecase.GetTvShowsUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateTvShowUseCase
import com.example.moviesseriesproject.ui.viewmodel.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory =
        TvShowViewModelFactory(getTvShowsUseCase,updateTvShowUseCase)
}