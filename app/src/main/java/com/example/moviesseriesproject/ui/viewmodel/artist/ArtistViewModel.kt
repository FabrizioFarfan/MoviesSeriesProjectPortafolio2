package com.example.moviesseriesproject.ui.viewmodel.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesseriesproject.domain.usecase.GetArtistsUseCase
import com.example.moviesseriesproject.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData{
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData{
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }
}