package com.kmp.app.movie.extension

private val emailRegex = Regex(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

private val passwordRegex = Regex(
    "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,20}\$"
)

fun String.isEmailValid() = this.matches(emailRegex)

fun String.isPasswordValid() = this.matches(passwordRegex)