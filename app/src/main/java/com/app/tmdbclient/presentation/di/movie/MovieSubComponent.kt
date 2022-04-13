package com.app.tmdbclient.presentation.di.movie

import com.app.tmdbclient.presentation.artist.ArtistActivity
import com.app.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent
    }
}