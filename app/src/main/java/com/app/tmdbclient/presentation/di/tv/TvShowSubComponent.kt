package com.app.tmdbclient.presentation.di.tv

import com.app.tmdbclient.presentation.artist.ArtistActivity
import com.app.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create() : TvShowSubComponent
    }
}