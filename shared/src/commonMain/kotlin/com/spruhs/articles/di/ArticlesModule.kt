package com.spruhs.articles.di

import com.spruhs.articles.ArticlesService
import com.spruhs.articles.ArticlesUseCase
import com.spruhs.articles.ArticlesViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}