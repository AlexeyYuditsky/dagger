package com.alexeyyuditsky.dagger.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexeyyuditsky.dagger.R
import com.alexeyyuditsky.dagger.core.ResourceManager
import com.alexeyyuditsky.dagger.core.log
import com.alexeyyuditsky.dagger.data.News
import com.alexeyyuditsky.dagger.domain.NewsRepository
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class NewsDetailsViewModel(
    private val newsId: String,
    private val newsRepository: NewsRepository,
    private val resourceManager: ResourceManager
) : ViewModel() {

    init {
        log(resourceManager.getString(R.string.app_name))
    }

    val news: SharedFlow<News> = flow { emit(newsRepository.getNews(newsId)) }
        .shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)

}