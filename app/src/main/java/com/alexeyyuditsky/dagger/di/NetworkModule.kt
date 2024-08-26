package com.alexeyyuditsky.dagger.di

import com.alexeyyuditsky.dagger.data.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    fun provideProductionNewsService(moshiConverterFactory: MoshiConverterFactory): NewsService {
        return Retrofit.Builder()
            .addConverterFactory(moshiConverterFactory)
            .baseUrl("https://androidbrodcast.dev")
            .build()
            .create()
    }

    @Provides
    @Stage
    fun provideStageNewsService(moshiConverterFactory: MoshiConverterFactory): NewsService {
        return Retrofit.Builder()
            .addConverterFactory(moshiConverterFactory)
            .baseUrl("https://stage.androidbrodcast.dev")
            .build()
            .create()
    }

}