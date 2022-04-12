package com.app.tmdbclient.data.repository.artist.datasource

import com.app.tmdbclient.data.model.artist.ArtistList
import com.app.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistsRemoteDatasource {
    suspend fun getArtists() : Response<ArtistList>
}