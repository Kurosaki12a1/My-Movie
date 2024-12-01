package com.kmp.app.auth_core.di

import com.kmp.app.auth_core.KMPAuthInternalApi
import org.koin.core.Koin
import org.koin.core.component.KoinComponent

@KMPAuthInternalApi
abstract class KMPKoinComponent : KoinComponent {
    override fun getKoin(): Koin {
        requireNotNull(LibDependencyInitializer.koinApp) {
            "Make sure you invoked #initialize method"
        }
        return LibDependencyInitializer.koinApp?.koin!!
    }
}