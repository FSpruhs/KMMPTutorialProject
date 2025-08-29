package com.spruhs.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val http: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "a399430506824f64b2bd9d950e95e1be"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = http.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}