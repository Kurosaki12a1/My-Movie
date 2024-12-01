package com.kmp.app.auth_google.di


import com.kmp.app.auth_google.GoogleAuthProvider
import com.kmp.app.auth_google.GoogleAuthProviderImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val googleAuthPlatformModule = module {
    factoryOf(::GoogleAuthProviderImpl) bind GoogleAuthProvider::class
}