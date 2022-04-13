package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.api.TMDBService
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

}