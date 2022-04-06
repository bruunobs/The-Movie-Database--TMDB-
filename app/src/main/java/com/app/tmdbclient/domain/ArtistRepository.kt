package com.app.tmdbclient.domain

import com.app.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}