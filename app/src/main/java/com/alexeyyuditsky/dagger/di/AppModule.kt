package com.alexeyyuditsky.dagger.di

import android.content.Context
import com.alexeyyuditsky.dagger.core.ResourceManager
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AppBindModule::class,
        NetworkModule::class
    ]
)
class AppModule {

    @Provides
    @AppScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManager.Base(context)
    }

}