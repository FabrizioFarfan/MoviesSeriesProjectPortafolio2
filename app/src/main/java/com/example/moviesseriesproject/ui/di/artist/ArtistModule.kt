package com.example.moviesseriesproject.ui.di.artist

import com.example.moviesseriesproject.domain.usecase.GetArtistsUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateArtistsUseCase
import com.example.moviesseriesproject.ui.viewmodel.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides



@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory =
        ArtistViewModelFactory(getArtistsUseCase,updateArtistsUseCase)
}