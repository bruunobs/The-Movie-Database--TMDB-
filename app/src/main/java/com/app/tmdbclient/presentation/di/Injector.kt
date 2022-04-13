package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.app.tmdbclient.presentation.di.movie.MovieSubComponent
import com.app.tmdbclient.presentation.di.tv.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}