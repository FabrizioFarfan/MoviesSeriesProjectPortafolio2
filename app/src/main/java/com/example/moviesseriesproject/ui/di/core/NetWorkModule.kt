package com.example.moviesseriesproject.ui.di.core

import com.example.moviesseriesproject.data.api.MoviesSeriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetWorkModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideMoviesSeriesService(
        retrofit: Retrofit
    ): MoviesSeriesService = retrofit.create(MoviesSeriesService::class.java)

}