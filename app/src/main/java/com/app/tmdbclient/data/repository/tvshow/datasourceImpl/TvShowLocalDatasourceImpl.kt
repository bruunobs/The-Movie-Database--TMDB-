package com.app.tmdbclient.data.repository.tvshow.datasourceImpl

import com.app.tmdbclient.data.db.MovieDAO
import com.app.tmdbclient.data.db.TvShowDAO
import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow
import com.app.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDAO: TvShowDAO) : TvShowLocalDatasource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
       return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}