package com.app.tmdbclient.domain.repository

import com.app.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?

}