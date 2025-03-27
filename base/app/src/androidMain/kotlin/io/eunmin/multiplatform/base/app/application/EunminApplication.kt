package io.eunmin.multiplatform.base.app.application

import android.app.Application
import io.eunmin.multiplatform.common.EunminContext
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

open class EunminApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        EunminContext.init(this)
        Napier.base(DebugAntilog())
    }
}