package com.alexeyyuditsky.dagger.di

import com.alexeyyuditsky.dagger.presentation.MainActivity
import com.alexeyyuditsky.dagger.presentation.NewsDetailsFragment
import com.alexeyyuditsky.dagger.simpleExample.Computer
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ExampleModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: NewsDetailsFragment)

    val computer: Computer

}