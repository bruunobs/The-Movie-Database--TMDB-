package com.app.tmdbclient.data.repository.artist

import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists : List<Artist>)
    suspend fun clearAll()
}