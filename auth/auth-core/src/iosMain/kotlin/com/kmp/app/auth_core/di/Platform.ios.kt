package com.kmp.app.auth_core.di

import com.kmp.app.auth_core.KMPAuthInternalApi
import org.koin.dsl.module


@KMPAuthInternalApi
internal actual fun isAndroidPlatform(): Boolean = false

internal actual val platformModuleAuth = module {

}