package com.example.moviesseriesproject.ui.di

import com.example.moviesseriesproject.ui.di.artist.ArtistSubComponent
import com.example.moviesseriesproject.ui.di.movie.MovieSubComponent
import com.example.moviesseriesproject.ui.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}