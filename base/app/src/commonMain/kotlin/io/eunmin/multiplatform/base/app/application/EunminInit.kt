package io.eunmin.multiplatform.base.app.application

import io.eunmin.multiplatform.common.constants.EunminConstants
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object EunminInit {
    fun init() {
        if (EunminConstants.isDebug) {
            Napier.base(DebugAntilog())
        }
    }
}