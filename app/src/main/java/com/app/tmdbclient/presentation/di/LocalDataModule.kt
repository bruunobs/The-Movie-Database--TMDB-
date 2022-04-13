package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.db.ArtistDAO
import com.app.tmdbclient.data.db.MovieDAO
import com.app.tmdbclient.data.db.TvShowDAO
import com.app.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.app.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.app.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
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

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO) : TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO) : ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDAO)
    }
}