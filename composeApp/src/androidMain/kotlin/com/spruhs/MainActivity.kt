package com.spruhs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.spruhs.articles.ArticlesViewModel
import com.spruhs.screens.ArticleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val articlesViewModel: ArticlesViewModel by viewModels()

        setContent {
            ArticleScreen(articlesViewModel = articlesViewModel)
        }
    }
}