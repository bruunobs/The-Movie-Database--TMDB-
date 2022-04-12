package com.app.tmdbclient.data.repository.artist.datasourceImpl

import com.app.tmdbclient.data.db.ArtistDAO
import com.app.tmdbclient.data.db.MovieDAO
import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val movieDAO: ArtistDAO) : ArtistLocalDatasource {
    override suspend fun getArtistsFromDB(): List<Artist> {
       return movieDAO.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllArtists()
        }
    }
}