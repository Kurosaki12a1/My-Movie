package com.kmp.app.shared.usecase.auth

import com.kmp.app.firebase.domain.AuthService

class GetUserFlowUseCase(private val auth: AuthService) {
    operator fun invoke() = auth.currentUser
}