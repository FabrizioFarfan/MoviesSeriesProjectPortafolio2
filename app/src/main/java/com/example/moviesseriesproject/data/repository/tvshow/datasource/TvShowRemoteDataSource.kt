package com.example.moviesseriesproject.data.repository.tvshow.datasource

import com.example.moviesseriesproject.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}