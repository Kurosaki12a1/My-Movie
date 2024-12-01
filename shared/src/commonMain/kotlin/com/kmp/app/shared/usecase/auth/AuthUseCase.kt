package com.kmp.app.shared.usecase.auth

data class AuthUseCase(
    val signInUseCase: SignInUseCase,
    val signUpUseCase: SignUpUseCase,
    val forgetPasswordUseCase: ForgetPasswordUseCase,
    val signOutUseCase: SignOutUseCase,
    val getUserFlowUseCase: GetUserFlowUseCase
)