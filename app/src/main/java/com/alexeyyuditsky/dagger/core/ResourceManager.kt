package com.alexeyyuditsky.dagger.core

import android.content.Context
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resourceId: Int): String

    class Base(
        private val context: Context
    ) : ResourceManager {
        override fun getString(resourceId: Int): String {
            return context.getString(resourceId)
        }
    }

}