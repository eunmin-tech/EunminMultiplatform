package io.eunmin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform