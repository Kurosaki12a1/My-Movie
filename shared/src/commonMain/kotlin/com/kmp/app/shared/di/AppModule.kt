package com.kmp.app.shared.di

import com.kmp.app.auth_google.GoogleAuthCredentials
import com.kmp.app.auth_google.GoogleAuthProvider
import com.kmp.app.firebase.di.firebaseModule
import com.kmp.app.firebase.firebasePlatformModule
import com.kmp.app.navigation.di.navigationModule
import com.kmp.app.shared.constants.Constants.CLIENT_ID
import com.kmp.app.shared.usecase.auth.AuthUseCase
import com.kmp.app.shared.usecase.auth.ForgetPasswordUseCase
import com.kmp.app.shared.usecase.auth.GetUserFlowUseCase
import com.kmp.app.shared.usecase.auth.SignInUseCase
import com.kmp.app.shared.usecase.auth.SignOutUseCase
import com.kmp.app.shared.usecase.auth.SignUpUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(listOf(
            navigationModule,
            firebasePlatformModule(),
            googleCredentialsModule,
            firebaseModule,
            useCaseModule)
        )
    }

// Called by iOS?
fun initKoin() = initKoin { }

val googleCredentialsModule = module {
    GoogleAuthProvider.create(credentials = GoogleAuthCredentials(CLIENT_ID))
}

val useCaseModule = module {
    factory<AuthUseCase> {
        AuthUseCase(
            signInUseCase = SignInUseCase(get()),
            signUpUseCase = SignUpUseCase(get()),
            forgetPasswordUseCase = ForgetPasswordUseCase(get()),
            signOutUseCase = SignOutUseCase(get()),
            getUserFlowUseCase = GetUserFlowUseCase(get())
        )
    }
}