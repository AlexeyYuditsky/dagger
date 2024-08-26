package com.alexeyyuditsky.dagger.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.alexeyyuditsky.dagger.R
import com.alexeyyuditsky.dagger.appComponent
import com.alexeyyuditsky.dagger.data.Analytics
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<NewsDetailsFragment>(
                    containerViewId = R.id.fragments,
                    args = NewsDetailsFragment.makeArgs(TOP_NEWS_ID)
                )
            }
        }
    }

    @Inject
    fun trackOnStart(analytics: Analytics) {
        analytics.trackScreenShow()
    }

    private companion object {
        const val TOP_NEWS_ID = "top"
    }
}