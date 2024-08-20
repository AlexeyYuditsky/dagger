package com.alexeyyuditsky.dagger.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alexeyyuditsky.dagger.R
import com.alexeyyuditsky.dagger.appComponent
import com.alexeyyuditsky.dagger.data.News
import com.alexeyyuditsky.dagger.databinding.FragmentNewsDetailsBinding
import com.alexeyyuditsky.dagger.presentation.core.AbstractFragment
import com.alexeyyuditsky.dagger.util.stringArgs
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailsFragment :
    AbstractFragment<FragmentNewsDetailsBinding>(R.layout.fragment_news_details) {

    override fun bind(view: View) = FragmentNewsDetailsBinding.bind(view)

    private val newsId: String by stringArgs(ARG_NEWS_ID)
    private val viewModel by viewModels<NewsDetailsViewModel> { factory.create(newsId) }

    // Lazy и Provider не работаю с зависимостями, которые используют Assisted Inject
    @Inject
    lateinit var factory: NewsDetailsViewModelFactory.Factory

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.news
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collect(::updateUi)
        }
    }

    private fun updateUi(news: News) {
        if (view == null) return
        with(binding) {
            title.text = news.title
            body.text = news.body
        }
    }

    companion object {
        private const val ARG_NEWS_ID = "news_id"

        fun makeArgs(newsId: String): Bundle {
            return Bundle(1).apply {
                putString(ARG_NEWS_ID, newsId)
            }
        }
    }
}