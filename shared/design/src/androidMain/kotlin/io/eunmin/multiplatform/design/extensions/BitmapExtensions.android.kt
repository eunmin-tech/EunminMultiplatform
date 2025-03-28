package io.eunmin.multiplatform.design.extensions

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import coil3.Bitmap

actual fun Bitmap.asImageBitmap(): ImageBitmap = this.asImageBitmap()