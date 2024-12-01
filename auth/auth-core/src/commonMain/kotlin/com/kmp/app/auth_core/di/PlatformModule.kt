package com.kmp.app.auth_core.di

import com.kmp.app.auth_core.KMPAuthInternalApi
import org.koin.core.module.Module

@KMPAuthInternalApi
internal expect fun isAndroidPlatform(): Boolean

internal expect val platformModuleAuth: Module