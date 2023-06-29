package com.example.moviesseriesproject.ui.app

import android.app.Application
import com.example.moviesseriesproject.BuildConfig
import com.example.moviesseriesproject.ui.di.Injector
import com.example.moviesseriesproject.ui.di.artist.ArtistSubComponent
import com.example.moviesseriesproject.ui.di.core.*
import com.example.moviesseriesproject.ui.di.movie.MovieSubComponent
import com.example.moviesseriesproject.ui.di.tvshow.TvShowSubComponent

class App: Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netWorkModule(NetWorkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createMovieSubComponent(): MovieSubComponent =
        appComponent.movieSubComponent().create()


    override fun createTvShowSubComponent(): TvShowSubComponent =
        appComponent.tvShowSubComponent().create()


    override fun createArtistSubComponent(): ArtistSubComponent =
        appComponent.artistSubComponent().create()
}