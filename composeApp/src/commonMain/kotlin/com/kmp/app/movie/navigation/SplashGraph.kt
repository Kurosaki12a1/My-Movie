package com.kmp.app.movie.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kmp.app.movie.screen.splash.SplashScreen
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationGraph

fun NavGraphBuilder.splashGraph() {
    navigation<NavigationGraph.SplashGraph>(
        startDestination = Destination.Splash
    ) {
        composable<Destination.Splash> {
            SplashScreen()
        }
    }
}