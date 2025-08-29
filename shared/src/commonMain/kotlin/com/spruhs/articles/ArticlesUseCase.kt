package com.spruhs.articles

import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticlesUseCase(private val articlesService: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        return articlesService.fetchArticles().map { it.toArticle() }
    }
    private fun ArticleRaw.toArticle() = Article(
        title = title,
        description = desc ?: "Click to find out more",
        imageUrl = imageUrl ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080",
        date = getDaysAgoString(date)
    )

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.now()
        val days = today.daysUntil(
            Instant.parse(date),
            timeZone = TimeZone.currentSystemDefault()
        )

        val result = when {
            abs(days) > 1 -> "$days days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}

