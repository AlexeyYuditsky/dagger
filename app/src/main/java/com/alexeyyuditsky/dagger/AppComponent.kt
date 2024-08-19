package com.alexeyyuditsky.dagger

import com.alexeyyuditsky.dagger.simpleExample.Computer
import com.alexeyyuditsky.dagger.simpleExample.Motherboard
import com.alexeyyuditsky.dagger.simpleExample.Processor
import com.alexeyyuditsky.dagger.simpleExample.RAM
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    val computer: Computer

}

@Module
class AppModule {

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }

    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

}