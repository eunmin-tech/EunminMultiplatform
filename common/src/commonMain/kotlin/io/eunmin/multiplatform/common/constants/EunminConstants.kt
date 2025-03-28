package io.eunmin.multiplatform.common.constants

import io.eunmin.multiplatform.common.enums.DeviceType

expect object EunminConstants {
    val isDebug: Boolean
    val deviceType: DeviceType
}