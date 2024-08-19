package com.alexeyyuditsky.dagger.simpleExample

import com.alexeyyuditsky.dagger.DaggerAppComponent

fun main() {
    val appComponent = DaggerAppComponent.create()
    val computer = appComponent.computer
    println(computer)
}