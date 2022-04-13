package com.app.tmdbclient.presentation.di.core

import android.content.Context
import com.app.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.app.tmdbclient.presentation.di.movie.MovieSubComponent
import com.app.tmdbclient.presentation.di.tv.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class,TvShowSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideAppAplicationContext() : Context{
        return context.applicationContext
    }
}