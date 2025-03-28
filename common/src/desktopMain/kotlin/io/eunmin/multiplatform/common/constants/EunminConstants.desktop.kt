package io.eunmin.multiplatform.common.constants

import io.eunmin.multiplatform.common.enums.DeviceType

actual object EunminConstants {
    actual val isDebug: Boolean
        get() = System.getenv("DEBUG")?.toBoolean() ?: false

    actual val deviceType: DeviceType
        get() = DeviceType.DESKTOP
}