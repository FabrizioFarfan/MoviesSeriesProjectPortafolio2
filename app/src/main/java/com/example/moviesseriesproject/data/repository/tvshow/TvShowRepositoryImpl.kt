package com.example.moviesseriesproject.data.repository.tvshow

import android.util.Log
import com.example.moviesseriesproject.data.model.tvshow.TvShow
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviesseriesproject.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {

        return getTvShowsFromCache()
    }
    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)

        return newTvShowList
    }


    suspend fun getTvShowsFromApi() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) tvShowList = body.tvShows
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDatabase() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (tvShowList.isNotEmpty()) return tvShowList
        else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (e: Exception){
            Log.i("My Tag",e.message.toString())
        }

        if (tvShowList.isNotEmpty()) return tvShowList
        else {
            tvShowList = getTvShowsFromDatabase()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}