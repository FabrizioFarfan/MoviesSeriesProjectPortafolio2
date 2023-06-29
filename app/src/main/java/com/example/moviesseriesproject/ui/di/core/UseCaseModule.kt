package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.domain.repository.ArtistRepository
import com.example.moviesseriesproject.domain.repository.MovieRepository
import com.example.moviesseriesproject.domain.repository.TvShowRepository
import com.example.moviesseriesproject.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase =
        GetTvShowsUseCase(tvShowRepository)

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase =
        UpdateTvShowUseCase(tvShowRepository)

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase =
        GetArtistsUseCase(artistRepository)

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepository)

}