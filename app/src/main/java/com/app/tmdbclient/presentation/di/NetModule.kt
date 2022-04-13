package com.app.tmdbclient.presentation.di

import com.app.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl : String) {
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    }
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit) :TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}