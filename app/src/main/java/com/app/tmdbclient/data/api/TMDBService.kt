package com.app.tmdbclient.data.api

import com.app.tmdbclient.data.ArtistList
import com.app.tmdbclient.data.MovieList
import com.app.tmdbclient.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET(value = "movie/popular")
    suspend fun getPopularMovies(@Query(value = "api_key")apiKey:String):Response<MovieList>

    @GET(value = "person/popular")
    suspend fun getPopularArtists(@Query(value = "api_key")apiKey:String):Response<ArtistList>

    @GET(value = "tv/popular")
    suspend fun getPopularTvShows(@Query(value = "api_key")apiKey:String):Response<TvShowList>
}