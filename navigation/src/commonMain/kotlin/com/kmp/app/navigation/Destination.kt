package com.kmp.app.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
sealed class Destination {
    @Serializable
    @SerialName("Splash")
    data object Splash : Destination()

    @Serializable
    @SerialName("SignIn")
    data object SignIn : Destination()

    @Serializable
    @SerialName("SignUp")
    data object SignUp : Destination()

    @Serializable
    @SerialName("ForgetPassword")
    data object ForgetPassword : Destination()

    @Serializable
    @SerialName("Home")
    data object Home : Destination()

    @Serializable
    @SerialName("Explore")
    data object Explore : Destination()

    @Serializable
    @SerialName("UpComing")
    data object UpComing : Destination()

    @Serializable
    @SerialName("Bookmark")
    data object Bookmark: Destination()

    @Serializable
    @SerialName("Settings")
    data object Settings: Destination()

}