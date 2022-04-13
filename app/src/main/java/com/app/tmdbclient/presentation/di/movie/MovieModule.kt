package com.app.tmdbclient.presentation.di.movie

import com.app.tmdbclient.domain.usecase.GetArtistUseCase
import com.app.tmdbclient.domain.usecase.GetMoviesUseCase
import com.app.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.app.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.app.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.app.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,updateMoviesUseCase
        )
    }
}