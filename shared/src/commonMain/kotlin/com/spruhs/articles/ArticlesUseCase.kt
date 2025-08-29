package com.spruhs.articles

class ArticlesUseCase(private val articlesService: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        return articlesService.fetchArticles().map { it.toArticle() }
    }
}

private fun ArticleRaw.toArticle()= Article(
        title = title,
        description = desc ?: "Click to find out more",
        imageUrl = imageUrl ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080",
        date = date,
    )