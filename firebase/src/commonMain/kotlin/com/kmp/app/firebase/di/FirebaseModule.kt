package com.kmp.app.firebase.di

import com.kmp.app.firebase.data.AuthServiceImpl
import com.kmp.app.firebase.domain.AuthService
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.dsl.module

val firebaseModule = module {
    single<FirebaseAuth> { Firebase.auth(get()) }
    single<AuthService> { AuthServiceImpl(get()) }
}