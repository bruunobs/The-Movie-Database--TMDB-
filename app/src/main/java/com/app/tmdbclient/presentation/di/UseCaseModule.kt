package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.domain.repository.MovieRepository
import com.app.tmdbclient.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase((movieRepository))
    }
}