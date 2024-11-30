package com.kmp.app.movie.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kmp.app.navigation.NavigationGraph

@Composable
fun MainNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = NavigationGraph.SplashGraph
    ) {
        splashGraph()
        authGraph()
        homeGraph()
        exploreGraph()
        upComingGraph()
        bookmarkGraph()
        settingsGraph()
    }
}