package com.kmp.app.navigation

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {
    val navigationFlow: SharedFlow<NavigationIntent>

    suspend fun navigateBack(
        route: Destination? = null,
        inclusive: Boolean = false
    )

    suspend fun navigateTo(
        route: Destination,
        popUpToRoute: Destination? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}

sealed class NavigationIntent {
    data class NavigateBack(
        val route: Destination? = null,
        val inclusive: Boolean = false
    ) : NavigationIntent()

    data class NavigateTo(
        val route: Destination,
        val popUpToRoute: Destination? = null,
        val inclusive: Boolean = false,
        val isSingleTop: Boolean = false
    ) : NavigationIntent()
}