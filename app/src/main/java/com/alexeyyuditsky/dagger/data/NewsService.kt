package com.alexeyyuditsky.dagger.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface NewsService {

    @GET
    suspend fun testNews(
        @Url url: String = "https://raw.githubusercontent.com/AlexeyYuditsky/server/master/news?token=$TOKEN"
    ): News

    @GET("news")
    suspend fun news(): List<News>

    @GET("news/{id}")
    suspend fun news(@Path("id") id: String): News

    private companion object {
        const val TOKEN = "GHSAT0AAAAAACODASTVRHPTSX6VQYA2T6IYZWF6C7A"
    }
}