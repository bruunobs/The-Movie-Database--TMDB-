package com.app.tmdbclient.data.repository

import com.app.tmdbclient.data.model.movie.Movie

class MovieCacheDataSourceImpl : MovieCacheDatasource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesFromCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}