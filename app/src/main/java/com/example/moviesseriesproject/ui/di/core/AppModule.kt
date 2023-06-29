package com.example.moviesseriesproject.ui.di.core

import android.content.Context
import com.example.moviesseriesproject.ui.di.artist.ArtistSubComponent
import com.example.moviesseriesproject.ui.di.movie.MovieSubComponent
import com.example.moviesseriesproject.ui.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = context.applicationContext

}