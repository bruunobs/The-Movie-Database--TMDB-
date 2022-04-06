package com.app.tmdbclient.domain.usecase

import com.app.tmdbclient.data.model.tvshow.TvShow
import com.app.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.updateTvShows()
}