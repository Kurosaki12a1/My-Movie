package com.kmp.app.shared.di

import com.kmp.app.navigation.di.navigationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(listOf(navigationModule))
    }

// Called by iOS?
fun initKoin() = initKoin { }