package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.domain.repository.MovieRepository
import dagger.Provides
import javax.inject.Singleton

class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ) : MovieRepository{
return MovieRepositoryImpl(
    movieRemoteDatasource,
    movieLocalDatasource,
    movieCacheDatasource
)
    }
}