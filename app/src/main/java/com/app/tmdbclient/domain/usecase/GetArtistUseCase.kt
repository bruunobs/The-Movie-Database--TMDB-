package com.app.tmdbclient.domain.usecase

import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.getArtists()
}