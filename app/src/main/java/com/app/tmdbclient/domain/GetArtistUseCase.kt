package com.app.tmdbclient.domain

import com.app.tmdbclient.data.model.artist.Artist

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.getArtists()
}