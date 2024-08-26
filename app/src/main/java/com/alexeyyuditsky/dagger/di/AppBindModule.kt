package com.alexeyyuditsky.dagger.di

import com.alexeyyuditsky.dagger.domain.NewsRepository
import com.alexeyyuditsky.dagger.data.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}