package com.kmp.app.firebase.data

import com.kmp.app.firebase.domain.AuthService
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class AuthServiceImpl(
    private val auth: FirebaseAuth,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
) : AuthService {
    override val currentUser: Flow<FirebaseUser?>
        get() = auth.authStateChanged

    override suspend fun authenticate(email: String, password: String) {
        launchWithAwait {
            auth.signInWithEmailAndPassword(email, password)
        }
    }

    override suspend fun signUp(email: String, password: String) {
        launchWithAwait {
            auth.createUserWithEmailAndPassword(email, password)
        }
    }

    override suspend fun forgetPassword(email: String) {
        launchWithAwait {
            auth.sendPasswordResetEmail(email)
        }
    }

    override suspend fun signOut() {
        if (auth.currentUser == null || auth.currentUser?.isAnonymous == true) {
            auth.currentUser?.delete()
        }
        auth.signOut()
    }

    private suspend fun launchWithAwait(block: suspend () -> Unit) {
        scope.async {
            block()
        }.await()
    }
}