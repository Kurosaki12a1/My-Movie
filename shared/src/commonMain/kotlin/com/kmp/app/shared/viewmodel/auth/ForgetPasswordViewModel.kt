package com.kmp.app.shared.viewmodel.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.kmp.app.shared.viewmodel.BaseViewModel

class ForgetPasswordViewModel : BaseViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private var isSetUpEmail = false

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setEmailFirstTime(email: String) {
        if (!isSetUpEmail) {
            setEmail(email)
            isSetUpEmail = true
        }
    }

    fun sendEmailResetPassword() {

    }
}