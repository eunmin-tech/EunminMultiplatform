package io.eunmin.multiplatform.design.extensions

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import coil3.Bitmap
import coil3.Image
import coil3.toBitmap

actual fun Bitmap.asImageBitmap(): ImageBitmap = this.asComposeImageBitmap()
