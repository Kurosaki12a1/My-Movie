package com.kmp.app.firebase.domain

import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthService {
    val currentUser: Flow<FirebaseUser?>

    suspend fun authenticate(email: String, password: String)

    suspend fun signUp(email: String, password: String)

    suspend fun forgetPassword(email : String)

    suspend fun signOut()
}