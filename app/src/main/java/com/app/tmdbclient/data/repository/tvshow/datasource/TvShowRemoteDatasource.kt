package com.app.tmdbclient.data.repository.tvshow.datasource

import com.app.tmdbclient.data.model.movie.MovieList
import com.app.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows() : Response<TvShowList>
}