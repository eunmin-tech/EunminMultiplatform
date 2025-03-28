package io.eunmin.multiplatform.common.constants

import io.eunmin.multiplatform.common.enums.DeviceType
import kotlin.experimental.ExperimentalNativeApi

actual object EunminConstants {
    @OptIn(ExperimentalNativeApi::class)
    actual val isDebug: Boolean
        get() = Platform.isDebugBinary

    actual val deviceType: DeviceType
        get() = DeviceType.IOS
}