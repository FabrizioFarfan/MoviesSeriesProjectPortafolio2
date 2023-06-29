package com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl

import com.example.moviesseriesproject.data.db.TvShowDao
import com.example.moviesseriesproject.data.model.tvshow.TvShow
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}