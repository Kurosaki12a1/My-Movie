package com.kmp.app.shared.viewmodel.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.kmp.app.shared.usecase.auth.AuthUseCase
import com.kmp.app.shared.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authUseCase: AuthUseCase
) : BaseViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _shouldShowPassword = mutableStateOf(false)
    val shouldShowPassword: State<Boolean> = _shouldShowPassword

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setShouldShowPassword() {
        _shouldShowPassword.value = !_shouldShowPassword.value
    }

    fun signInWithEmailAndPassword() {
        viewModelScope.launch {
            authUseCase.signInUseCase(email.value, password.value)
        }
    }
}