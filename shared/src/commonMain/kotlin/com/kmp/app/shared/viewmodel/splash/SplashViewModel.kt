package com.kmp.app.shared.viewmodel.splash

import androidx.lifecycle.viewModelScope
import com.kmp.app.navigation.Destination
import com.kmp.app.shared.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : BaseViewModel() {

    companion object {
        private const val DELAY = 2000L
    }

    init {
        viewModelScope.launch {
            delay(DELAY)
            navigateTo(
                route = Destination.SignIn,
                popUpToRoute = Destination.Splash,
                inclusive = true,
                isSingleTop = true
            )
        }
    }

}