package io.eunmin.multiplatform.common.constants

import io.eunmin.multiplatform.common.BuildConfig
import io.eunmin.multiplatform.common.enums.DeviceType

actual object EunminConstants {
    actual val isDebug: Boolean
        get() = BuildConfig.DEBUG

    actual val deviceType: DeviceType
        get() = DeviceType.ANDROID
}