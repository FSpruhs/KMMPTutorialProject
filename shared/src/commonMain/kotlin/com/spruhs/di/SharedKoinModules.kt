package com.spruhs.di

import com.spruhs.articles.di.articleModule

val sharedKoinModules = listOf(
    articleModule,
    networkModule
)