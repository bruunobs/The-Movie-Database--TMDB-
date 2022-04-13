package com.app.tmdbclient.presentation.di.artist

import com.app.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create() : ArtistSubComponent
    }
}