package com.kmp.app.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
sealed class NavigationGraph {
    @Serializable
    @SerialName("AuthGraph")
    data object AuthGraph : NavigationGraph()

    @Serializable
    @SerialName("SplashGraph")
    data object SplashGraph : NavigationGraph()

    @Serializable
    @SerialName("HomeGraph")
    data object HomeGraph : NavigationGraph()

    @Serializable
    @SerialName("DetailGraph")
    data object DetailGraph : NavigationGraph()

    @Serializable
    @SerialName("UpComingGraph")
    data object UpComingGraph : NavigationGraph()

    @Serializable
    @SerialName("ExploreGraph")
    data object ExploreGraph : NavigationGraph()

    @Serializable
    @SerialName("SettingsGraph")
    data object SettingsGraph : NavigationGraph()

    @Serializable
    @SerialName("BookmarkGraph")
    data object BookmarkGraph : NavigationGraph()

    @Serializable
    @SerialName("PersonDetailGraph")
    data object PersonDetailGraph : NavigationGraph()
}