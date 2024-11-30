package com.kmp.app.movie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform