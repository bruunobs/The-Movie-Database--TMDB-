package com.app.tmdbclient.data.repository.artist.datasourceImpl

import com.app.tmdbclient.data.model.artist.Artist
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource

class ArtistCacheDataSourceImpl : ArtistCacheDatasource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsFromCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}