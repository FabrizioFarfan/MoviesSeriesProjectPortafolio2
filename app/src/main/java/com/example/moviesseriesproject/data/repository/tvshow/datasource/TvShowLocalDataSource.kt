package com.example.moviesseriesproject.data.repository.tvshow.datasource

import com.example.moviesseriesproject.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()

}