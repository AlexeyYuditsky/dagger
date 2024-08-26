package com.alexeyyuditsky.dagger.data

import com.alexeyyuditsky.dagger.domain.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val analytics: Analytics
) : NewsRepository {

    override suspend fun getNews(newsId: String): News {
        analytics.trackNewsRequest(newsId)
        //return newsService.news(newsId)
        //return newsService.testNews(/*newsId*/)
        return News("1", "Test", "Lalallalalalalala")
    }

}