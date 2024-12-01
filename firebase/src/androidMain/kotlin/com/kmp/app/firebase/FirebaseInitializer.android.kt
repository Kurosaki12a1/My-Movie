package com.kmp.app.firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseApp
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun firebasePlatformModule(): Module = module {
    single<FirebaseApp> {
        Firebase.initialize(
            context = androidContext().applicationContext,
            options = FirebaseOptions(
                applicationId = "1:272268189669:android:023c7957edebef8b1b590c",
                projectId = "movie-kmp",
                apiKey = "AIzaSyCpGgiKEURNqVflZkg7D4GpMi3KosGncoE"
            )
        )
    }
}