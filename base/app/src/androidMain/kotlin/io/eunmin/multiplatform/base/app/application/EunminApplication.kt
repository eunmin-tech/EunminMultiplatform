package io.eunmin.multiplatform.base.app.application

import android.app.Application
import io.eunmin.multiplatform.common.EunminContext

open class EunminApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        EunminContext.init(this)
        EunminInit.init()
    }
}