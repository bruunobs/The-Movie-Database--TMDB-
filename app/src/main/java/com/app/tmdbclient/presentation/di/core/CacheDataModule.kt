package com.app.tmdbclient.presentation.di.core

import com.app.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.app.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.app.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDatasource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowCacheDatasource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDatasource{
        return ArtistCacheDataSourceImpl()
    }
}