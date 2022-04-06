package com.app.tmdbclient.domain.usecase

import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}