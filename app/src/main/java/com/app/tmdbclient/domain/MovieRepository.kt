package com.app.tmdbclient.domain

import com.app.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    
}