package com.app.tmdbclient.data.repository.tvshow.datasourceImpl

import com.app.tmdbclient.data.model.movie.Movie
import com.app.tmdbclient.data.model.tvshow.TvShow
import com.app.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDataSourceImpl : TvShowCacheDatasource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsFromCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}