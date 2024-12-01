package com.kmp.app.firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseApp
import dev.gitlive.firebase.FirebaseOptions
import dev.gitlive.firebase.initialize
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun firebasePlatformModule(): Module = module {
    single<FirebaseApp> {
        Firebase.initialize(
            options = FirebaseOptions(
                applicationId = "1:272268189669:ios:f83ca95a5383ee4b1b590c",
                projectId = "movie-kmp",
                apiKey = "AIzaSyCa1yuJqm_xWN75yXETOGnsaqsoeriwKss"
            )
        )
    }
}