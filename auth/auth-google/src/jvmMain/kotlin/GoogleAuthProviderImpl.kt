package com.kmp.app.auth_google

import androidx.compose.runtime.Composable

internal class GoogleAuthProviderImpl : GoogleAuthProvider {
    @Composable
    override fun getUiProvider(): GoogleAuthUiProvider = GoogleAuthUiProviderImpl()

    override suspend fun signOut() {
    }
}