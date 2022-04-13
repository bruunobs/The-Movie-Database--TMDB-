package com.app.tmdbclient.presentation.di.tv

import com.app.tmdbclient.domain.usecase.GetArtistUseCase
import com.app.tmdbclient.domain.usecase.GetTvShowUseCase
import com.app.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.app.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.app.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.app.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowUseCase, updateTvShowsUseCase
        )
    }
}