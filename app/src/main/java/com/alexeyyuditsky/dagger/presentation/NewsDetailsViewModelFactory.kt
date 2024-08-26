package com.alexeyyuditsky.dagger.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexeyyuditsky.dagger.core.ResourceManager
import com.alexeyyuditsky.dagger.domain.NewsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewsDetailsViewModelFactory @AssistedInject constructor(
    @Assisted private val newsId: String,
    private val newsRepository: NewsRepository,
    private val resourceManager: ResourceManager
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == NewsDetailsViewModel::class.java)
        return NewsDetailsViewModel(newsId, newsRepository, resourceManager) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted newsId: String): NewsDetailsViewModelFactory
    }
}