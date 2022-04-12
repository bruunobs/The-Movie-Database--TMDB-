package com.app.tmdbclient.data.repository.artist

import android.provider.MediaStore
import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsFromCache(artists : List<Artist> )
}