package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.data.api.MoviesSeriesService
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesseriesproject.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesseriesproject.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl.TvShowRemoteSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteSource(moviesSeriesService: MoviesSeriesService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(
            moviesSeriesService,apiKey
        )

    @Singleton
    @Provides
    fun provideTvShowRemoteSource(moviesSeriesService: MoviesSeriesService): TvShowRemoteDataSource =
        TvShowRemoteSourceImpl(
            moviesSeriesService,apiKey
        )

    @Singleton
    @Provides
    fun provideArtistRemoteSource(moviesSeriesService: MoviesSeriesService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(
            moviesSeriesService,apiKey
        )


}