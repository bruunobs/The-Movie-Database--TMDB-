package com.app.tmdbclient.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideAppAplicationContext() : Context{
        return context.applicationContext
    }
}