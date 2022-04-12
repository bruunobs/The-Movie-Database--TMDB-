package com.app.tmdbclient.data.repository.movie.datasource

import com.app.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesFromCache(movies : List<Movie> )
}