package com.kmp.app.shared.usecase.auth

import com.kmp.app.firebase.domain.AuthService

class SignUpUseCase(private val auth: AuthService) {
    suspend operator fun invoke(email: String, password: String) = auth.signUp(email, password)
}