package com.spruhs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.spruhs.articles.ArticlesViewModel
import com.spruhs.screens.AboutScreen
import com.spruhs.screens.ArticleScreen
import com.spruhs.screens.Screen

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier.fillMaxSize().padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            ArticleScreen(
                onAboutButtonClick = { navController.navigate(Screen.ABOUT.route) },
            )
        }
        composable(Screen.ABOUT.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() },
            )
        }
    }
}