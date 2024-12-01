package com.kmp.app.shared.usecase.auth

import com.kmp.app.firebase.domain.AuthService

class ForgetPasswordUseCase(private val auth: AuthService) {
    suspend operator fun invoke(email: String) = auth.forgetPassword(email)
}