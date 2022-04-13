package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.db.MovieDAO
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO) : MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDAO)
    }
}