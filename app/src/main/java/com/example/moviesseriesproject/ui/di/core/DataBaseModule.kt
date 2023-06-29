package com.example.moviesseriesproject.ui.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviesseriesproject.data.db.ArtistDao
import com.example.moviesseriesproject.data.db.MovieDao
import com.example.moviesseriesproject.data.db.MoviesSeriesDatabase
import com.example.moviesseriesproject.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): MoviesSeriesDatabase = Room.databaseBuilder(
        context,
        MoviesSeriesDatabase::class.java,
        "moviesseriesclient"
    ).build()

    @Singleton
    @Provides
    fun provideMovieDao(moviesSeriesDatabase: MoviesSeriesDatabase) : MovieDao = moviesSeriesDatabase.movieDao()


    @Singleton
    @Provides
    fun provideTvShowDao(moviesSeriesDatabase: MoviesSeriesDatabase) : TvShowDao = moviesSeriesDatabase.tvDao()


    @Singleton
    @Provides
    fun provideArtistDao(moviesSeriesDatabase: MoviesSeriesDatabase) : ArtistDao = moviesSeriesDatabase.artistDao()


}