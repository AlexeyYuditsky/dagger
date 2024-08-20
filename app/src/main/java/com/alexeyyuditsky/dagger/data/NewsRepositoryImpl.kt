package com.alexeyyuditsky.dagger.data

import com.alexeyyuditsky.dagger.domain.NewsRepository
import javax.inject.Inject
import javax.inject.Named

class NewsRepositoryImpl @Inject constructor(
    @Named("prod") private val newsService: NewsService,
    private val analytics: Analytics
) : NewsRepository {

    override suspend fun getNews(newsId: String): News {
        analytics.trackNewsRequest(newsId)
        return newsService.news(newsId)
    }

}