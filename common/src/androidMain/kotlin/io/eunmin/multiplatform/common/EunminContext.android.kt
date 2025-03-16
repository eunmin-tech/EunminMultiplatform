package io.eunmin.multiplatform.common

import android.app.Application
import android.content.Context

actual object EunminContext {
    private lateinit var application: Application

    val instance: Context
        get() {
            if (EunminContext::application.isInitialized.not()) throw Exception("Application context isn't initialized")
            return application.applicationContext
        }

    fun init(context: Context) {
        application = context as Application
    }
}