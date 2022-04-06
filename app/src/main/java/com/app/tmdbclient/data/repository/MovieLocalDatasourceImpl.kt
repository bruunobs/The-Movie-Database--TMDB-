package com.app.tmdbclient.data.repository

import com.app.tmdbclient.data.db.MovieDAO
import com.app.tmdbclient.data.model.movie.Movie

class MovieLocalDatasourceImpl(private val movieDAO: MovieDAO) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAll() {
        TODO("Not yet implemented")
    }
}