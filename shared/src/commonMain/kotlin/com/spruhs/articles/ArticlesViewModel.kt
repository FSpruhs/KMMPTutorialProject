package com.spruhs.articles

import com.spruhs.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase,
): BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val articleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = useCase.getArticles()
            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }
}

