package com.example.moviesseriesproject.domain.repository

import com.example.moviesseriesproject.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?

}