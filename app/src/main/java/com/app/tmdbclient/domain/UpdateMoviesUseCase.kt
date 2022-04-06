package com.app.tmdbclient.domain

import com.app.tmdbclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}