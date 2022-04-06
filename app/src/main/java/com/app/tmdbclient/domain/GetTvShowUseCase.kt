package com.app.tmdbclient.domain

import com.app.tmdbclient.data.model.tvshow.TvShow

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}