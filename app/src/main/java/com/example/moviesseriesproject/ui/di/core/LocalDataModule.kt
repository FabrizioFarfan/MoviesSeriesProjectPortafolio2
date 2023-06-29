package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.data.db.ArtistDao
import com.example.moviesseriesproject.data.db.MovieDao
import com.example.moviesseriesproject.data.db.TvShowDao
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesseriesproject.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesseriesproject.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieDataLocalSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)


    @Singleton
    @Provides
    fun provideTvShowDataLocalSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDao)


    @Singleton
    @Provides
    fun provideArtistDataLocalSource(artistDao: ArtistDao): ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)


}