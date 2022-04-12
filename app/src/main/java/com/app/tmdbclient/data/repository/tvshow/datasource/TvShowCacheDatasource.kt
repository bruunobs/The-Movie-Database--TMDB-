package com.app.tmdbclient.data.repository.tvshow.datasource

import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowsFromCache(movies : List<TvShow> )
}