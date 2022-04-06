package com.app.tmdbclient.domain.repository

import com.app.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}