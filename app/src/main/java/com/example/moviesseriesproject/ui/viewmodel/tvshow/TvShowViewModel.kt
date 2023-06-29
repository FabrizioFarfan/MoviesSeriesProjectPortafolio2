package com.example.moviesseriesproject.ui.viewmodel.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesseriesproject.domain.usecase.GetTvShowsUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData{
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData{
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }

}