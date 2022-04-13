package com.app.tmdbclient.presentation.di.artist

import com.app.tmdbclient.domain.usecase.GetArtistUseCase
import com.app.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.app.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase,updateArtistsUseCase
        )
    }
}