package com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl

import com.example.moviesseriesproject.data.model.tvshow.TvShow
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private  var tvShowList: ArrayList<TvShow> = ArrayList()


    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {

        tvShowList.clear()
        tvShowList = ArrayList(tvShows)

    }
}