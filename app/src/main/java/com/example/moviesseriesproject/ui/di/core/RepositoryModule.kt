package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.domain.repository.ArtistRepository
import com.example.moviesseriesproject.domain.repository.MovieRepository
import com.example.moviesseriesproject.domain.repository.TvShowRepository
import com.example.moviesseriesproject.data.repository.artist.ArtistRepositoryImpl
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesseriesproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesseriesproject.data.repository.movie.MovieRepositoryImpl
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviesseriesproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviesseriesproject.data.repository.tvshow.TvShowRepositoryImpl
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviesseriesproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }


}