package com.app.tmdbclient.data.repository.artist.datasourceImpl

import com.app.tmdbclient.data.api.TMDBService
import com.app.tmdbclient.data.model.artist.ArtistList
import com.app.tmdbclient.data.model.movie.MovieList
import com.app.tmdbclient.data.repository.artist.datasource.ArtistsRemoteDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey : String ) : ArtistsRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}