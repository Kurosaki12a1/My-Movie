package com.kmp.app.shared.usecase.auth

import com.kmp.app.firebase.domain.AuthService

class SignOutUseCase(private val auth: AuthService) {
    suspend operator fun invoke() = auth.signOut()
}