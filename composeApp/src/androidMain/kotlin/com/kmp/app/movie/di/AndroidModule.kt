package com.kmp.app.movie.di

import com.kmp.app.shared.viewmodel.BaseViewModel
import com.kmp.app.shared.viewmodel.auth.ForgetPasswordViewModel
import com.kmp.app.shared.viewmodel.auth.SignInViewModel
import com.kmp.app.shared.viewmodel.auth.SignUpViewModel
import com.kmp.app.shared.viewmodel.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BaseViewModel() }
    viewModel { SplashViewModel() }
    viewModel { SignInViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { ForgetPasswordViewModel() }
}