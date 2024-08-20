package com.alexeyyuditsky.dagger.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexeyyuditsky.dagger.data.News
import com.alexeyyuditsky.dagger.domain.NewsRepository
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class NewsDetailsViewModel(
    private val newsId: String,
    private val newsRepository: NewsRepository
) : ViewModel() {

    val news: SharedFlow<News> = flow<News> { newsRepository.getNews(newsId) }
        .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
}