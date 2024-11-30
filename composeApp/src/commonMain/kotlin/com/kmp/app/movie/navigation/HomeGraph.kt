package com.kmp.app.movie.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationGraph

fun NavGraphBuilder.homeGraph() {
    navigation<NavigationGraph.HomeGraph>(
        startDestination = Destination.Home
    ) {
        composable<Destination.Home> {

        }
    }
}