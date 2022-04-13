package com.app.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.tmdbclient.domain.usecase.GetArtistUseCase
import com.app.tmdbclient.domain.usecase.GetMoviesUseCase
import com.app.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.app.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistsUseCase) as T
    }


}