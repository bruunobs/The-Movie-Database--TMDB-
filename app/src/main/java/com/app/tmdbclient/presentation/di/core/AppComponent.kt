package com.app.tmdbclient.presentation.di.core

import com.app.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.app.tmdbclient.presentation.di.movie.MovieSubComponent
import com.app.tmdbclient.presentation.di.tv.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}