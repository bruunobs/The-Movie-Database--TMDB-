package com.app.tmdbclient.presentation.di.core

import com.app.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.app.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.app.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.app.tmdbclient.data.repository.artist.datasource.ArtistsRemoteDatasource
import com.app.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.app.tmdbclient.domain.repository.ArtistRepository
import com.app.tmdbclient.domain.repository.MovieRepository
import com.app.tmdbclient.domain.repository.TvShowRepository
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


    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ) : TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource)
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistsRemoteDatasource: ArtistsRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ) : ArtistRepository{
        return ArtistRepositoryImpl(
           artistsRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }
}