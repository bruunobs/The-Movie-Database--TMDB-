package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.api.TMDBService
import com.app.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.app.tmdbclient.data.repository.artist.datasource.ArtistsRemoteDatasource
import com.app.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.app.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
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

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDatasource{
        return TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistsRemoteDatasource{
        return ArtistRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

}