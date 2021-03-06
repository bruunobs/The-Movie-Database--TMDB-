package com.app.tmdbclient.domain.repository

import com.app.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}