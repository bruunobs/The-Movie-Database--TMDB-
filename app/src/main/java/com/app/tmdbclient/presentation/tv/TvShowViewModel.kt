package com.app.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.app.tmdbclient.domain.usecase.GetMoviesUseCase
import com.app.tmdbclient.domain.usecase.GetTvShowUseCase
import com.app.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.app.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(private val getTvShowUseCase: GetTvShowUseCase,
                      private val updateTvShowsUseCase: UpdateTvShowsUseCase) : ViewModel()  {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }

    
}