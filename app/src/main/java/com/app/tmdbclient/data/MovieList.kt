package com.app.tmdbclient.data
import com.app.tmdbclient.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>

)