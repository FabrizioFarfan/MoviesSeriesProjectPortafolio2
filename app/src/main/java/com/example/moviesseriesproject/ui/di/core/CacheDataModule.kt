package com.example.moviesseriesproject.ui.di.core


import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesseriesproject.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesseriesproject.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()


    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource = TvShowCacheDataSourceImpl()


    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()

}