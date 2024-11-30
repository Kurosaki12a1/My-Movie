package com.kmp.app.shared.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.Navigator
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseViewModel : ViewModel(), KoinComponent {
    private val navigator: Navigator by inject()

    fun navigateTo(
        route: Destination,
        popUpToRoute: Destination? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    ) {
        viewModelScope.launch {
            navigator.navigateTo(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop
            )
        }
    }

    fun navigateBack(
        route: Destination? = null,
        inclusive: Boolean = false
    ) {
        viewModelScope.launch {
            navigator.navigateBack(
                route = route,
                inclusive = inclusive
            )
        }
    }
}