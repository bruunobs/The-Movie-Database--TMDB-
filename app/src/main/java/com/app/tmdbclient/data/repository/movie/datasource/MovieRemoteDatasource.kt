package com.app.tmdbclient.data.repository.movie.datasource

import com.app.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies() : Response<MovieList>
}