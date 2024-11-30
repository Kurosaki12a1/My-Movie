package com.kmp.app.movie

import android.app.Application
import com.kmp.app.movie.di.appModule
import com.kmp.app.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MovieApplication)
            androidLogger()
            modules(appModule)
        }
    }
}