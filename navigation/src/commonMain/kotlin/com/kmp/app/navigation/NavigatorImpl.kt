package com.kmp.app.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigatorImpl : Navigator {
    private val _navigationFlow: MutableSharedFlow<NavigationIntent> =
        MutableSharedFlow(replay = 0)
    override val navigationFlow: SharedFlow<NavigationIntent>
        get() = _navigationFlow.asSharedFlow()

    override suspend fun navigateBack(route: Destination?, inclusive: Boolean) {
        _navigationFlow.emit(
            NavigationIntent.NavigateBack(
                route = route,
                inclusive = inclusive
            )
        )
    }

    override suspend fun navigateTo(
        route: Destination,
        popUpToRoute: Destination?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        _navigationFlow.emit(
            NavigationIntent.NavigateTo(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop
            )
        )
    }


}