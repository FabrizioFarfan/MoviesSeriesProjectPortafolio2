package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.ui.di.artist.ArtistSubComponent
import com.example.moviesseriesproject.ui.di.movie.MovieSubComponent
import com.example.moviesseriesproject.ui.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetWorkModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}