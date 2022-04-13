package com.app.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.app.tmdbclient.domain.usecase.GetArtistUseCase
import com.app.tmdbclient.domain.usecase.GetMoviesUseCase
import com.app.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.app.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(private val getArtistUseCase: GetArtistUseCase,
                      private val updateArtistsUseCase: UpdateArtistsUseCase) : ViewModel()  {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }

    
}