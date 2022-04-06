package com.app.tmdbclient.data.model.artist


import com.app.tmdbclient.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)