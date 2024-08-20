package com.alexeyyuditsky.dagger.di

import com.alexeyyuditsky.dagger.data.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @Named("prod")
    fun provideProductionNewsService(): NewsService {
        return Retrofit.Builder()
            .baseUrl("https://androidbrodcast.dev")
            .build()
            .create()
    }

    @Provides
    @Named("stage")
    fun provideStageNewsService(): NewsService {
        return Retrofit.Builder()
            .baseUrl("https://stage.androidbrodcast.dev")
            .build()
            .create()
    }

}