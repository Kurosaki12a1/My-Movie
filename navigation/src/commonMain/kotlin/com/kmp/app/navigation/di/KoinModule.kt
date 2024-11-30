package com.kmp.app.navigation.di

import com.kmp.app.navigation.Navigator
import com.kmp.app.navigation.NavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single<Navigator> { NavigatorImpl() }
}