package com.alexeyyuditsky.dagger.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.alexeyyuditsky.dagger.R
import com.alexeyyuditsky.dagger.appComponent
import com.alexeyyuditsky.dagger.data.Analytics
import com.alexeyyuditsky.dagger.util.isFragmentContainerEmpty
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        with(supportFragmentManager) {
            if (isFragmentContainerEmpty(R.id.fragments)) {
                commit {
                    add<NewsDetailsFragment>(
                        R.id.fragments,
                        FRAGMENT_NEWS_DETAILS,
                        NewsDetailsFragment.makeArgs(TOP_NEWS_ID)
                    )
                }
            }
        }
    }

    @Inject // todo проверить утверждение что данный метод вызовется только 1 раз (смена конфигурации)
    fun trackOnStart(analytics: Analytics) {
        analytics.trackScreenShow()
    }

    private companion object {
        const val TOP_NEWS_ID = "top"
        const val FRAGMENT_NEWS_DETAILS = "newsDetails"
    }
}