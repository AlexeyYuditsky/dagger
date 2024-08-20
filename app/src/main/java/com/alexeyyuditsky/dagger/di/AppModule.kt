package com.alexeyyuditsky.dagger.di

import dagger.Module

@Module(
    includes = [
        AppBindModule::class,
        NetworkModule::class
    ]
)
class AppModule