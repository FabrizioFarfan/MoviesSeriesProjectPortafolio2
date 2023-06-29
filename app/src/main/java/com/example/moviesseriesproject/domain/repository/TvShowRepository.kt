package com.example.moviesseriesproject.domain.repository

import com.example.moviesseriesproject.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}