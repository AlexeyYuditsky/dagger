package com.alexeyyuditsky.dagger

import android.app.Application
import android.content.Context

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}

@Suppress("RecursivePropertyAccessor")
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> {
            this.appComponent
        }

        else -> {
            this.applicationContext.appComponent
        }
    }