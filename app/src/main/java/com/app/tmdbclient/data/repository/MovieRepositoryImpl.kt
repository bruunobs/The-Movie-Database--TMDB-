package com.app.tmdbclient.data.repository

import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }
}