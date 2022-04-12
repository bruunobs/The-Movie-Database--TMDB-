package com.app.tmdbclient.data.repository.tvshow.datasourceImpl

import com.app.tmdbclient.data.api.TMDBService
import com.app.tmdbclient.data.model.movie.MovieList
import com.app.tmdbclient.data.model.tvshow.TvShowList
import com.app.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.app.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey : String ) : TvShowRemoteDatasource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}