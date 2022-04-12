package com.app.tmdbclient.data.repository.tvshow.datasource

import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(movies : List<TvShow>)
    suspend fun clearAll()
}