package com.example.moviesseriesproject.data.repository.tvshow.datasource

import com.example.moviesseriesproject.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}