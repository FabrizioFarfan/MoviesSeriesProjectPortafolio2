package com.example.moviesseriesproject.domain.usecase

import com.example.moviesseriesproject.data.model.artist.Artist
import com.example.moviesseriesproject.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}