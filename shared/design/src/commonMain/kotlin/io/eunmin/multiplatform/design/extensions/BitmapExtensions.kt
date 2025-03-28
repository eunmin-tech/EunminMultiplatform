package io.eunmin.multiplatform.design.extensions

import androidx.compose.ui.graphics.ImageBitmap
import coil3.Bitmap
import coil3.Image
import coil3.toBitmap

expect fun Bitmap.asImageBitmap(): ImageBitmap

fun Image.asImageBitmap(): ImageBitmap = this.toBitmap().asImageBitmap()
