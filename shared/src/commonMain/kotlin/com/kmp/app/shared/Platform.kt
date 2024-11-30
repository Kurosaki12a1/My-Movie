package com.kmp.app.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform