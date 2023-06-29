package com.example.moviesseriesproject.domain.usecase

import com.example.moviesseriesproject.data.model.tvshow.TvShow
import com.example.moviesseriesproject.domain.repository.TvShowRepository

class GetTvShowsUseCase(
    private val tvShowRepository: TvShowRepository
    ) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()

}