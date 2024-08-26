package com.alexeyyuditsky.dagger.di

import android.content.Context
import com.alexeyyuditsky.dagger.presentation.MainActivity
import com.alexeyyuditsky.dagger.presentation.NewsDetailsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [AppModule::class]
)
@AppScope
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: NewsDetailsFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}