package com.app.tmdbclient.data.model.tvshow


import com.app.tmdbclient.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>,
)
