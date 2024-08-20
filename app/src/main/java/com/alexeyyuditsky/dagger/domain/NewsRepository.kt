package com.alexeyyuditsky.dagger.domain

import com.alexeyyuditsky.dagger.data.News

interface NewsRepository {
    suspend fun getNews(newsId: String): News
}