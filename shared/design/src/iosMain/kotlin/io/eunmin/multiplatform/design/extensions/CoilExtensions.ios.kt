package io.eunmin.multiplatform.design.extensions

import coil3.request.ImageRequest

actual fun ImageRequest.Builder.androidAllowHardware(b: Boolean): ImageRequest.Builder = this