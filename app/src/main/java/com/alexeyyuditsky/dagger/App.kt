package com.alexeyyuditsky.dagger

import android.app.Application
import android.content.Context
import com.alexeyyuditsky.dagger.di.AppComponent
import com.alexeyyuditsky.dagger.di.DaggerAppComponent

class App : Application() {

    val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder()
            .context(this)
            .build()
    }

}

@Suppress("RecursivePropertyAccessor")
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> this.appComponent
        else -> this.applicationContext.appComponent
    }