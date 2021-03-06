package com.app.tmdbclient.data.repository.movie.datasourceImpl

import com.app.tmdbclient.data.api.TMDBService
import com.app.tmdbclient.data.model.movie.MovieList
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                private val apiKey : String ) : MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}