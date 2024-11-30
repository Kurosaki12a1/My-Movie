package com.kmp.app.movie.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationGraph

fun NavGraphBuilder.exploreGraph() {
    navigation<NavigationGraph.ExploreGraph>(
        startDestination = Destination.Explore
    ) {
        composable<Destination.Explore> {

        }
    }
}