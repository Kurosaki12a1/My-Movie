package com.kmp.app.movie.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kmp.app.movie.screen.auth.ForgetPasswordScreen
import com.kmp.app.movie.screen.auth.SignInScreen
import com.kmp.app.movie.screen.auth.SignUpScreen
import com.kmp.app.navigation.Destination
import com.kmp.app.navigation.NavigationGraph

fun NavGraphBuilder.authGraph() {
    navigation<NavigationGraph.AuthGraph>(
        startDestination = Destination.SignIn
    ) {
        composable<Destination.SignIn> {
            SignInScreen()
        }
        composable<Destination.SignUp> {
            SignUpScreen()
        }
        composable<Destination.ForgetPassword> {
            val email = it.arguments?.getString("email")
            ForgetPasswordScreen(
                emailTxt = email ?: ""
            )
        }
    }
}