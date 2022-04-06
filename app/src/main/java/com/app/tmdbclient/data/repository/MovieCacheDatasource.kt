package com.app.tmdbclient.data.repository

import com.app.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesFromCache(movies : List<Movie> )
}