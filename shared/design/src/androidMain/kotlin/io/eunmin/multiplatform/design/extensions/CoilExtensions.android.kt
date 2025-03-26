package io.eunmin.multiplatform.design.extensions

import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import coil3.request.ImageRequest
import coil3.request.allowHardware

actual fun ImageRequest.Builder.androidAllowHardware(b: Boolean): ImageRequest.Builder = allowHardware(b)
actual fun createImageBitmap(
    width: Int,
    height: Int
): ImageBitmap {
    val androidBitmap = createBitmap(width, height, Bitmap.Config.ARGB_8888)
        .copy(Bitmap.Config.ARGB_8888, true)
    return androidBitmap.asImageBitmap()
}

actual fun Painter.drawBitmap(bitmap: ImageBitmap, width: Int, height: Int, density: Density, layoutDirection: LayoutDirection): Bitmap {
    val androidBitmap = bitmap.asAndroidBitmap()
    val canvas = Canvas()
    canvas.setBitmap(androidBitmap)
    canvas.drawBitmap(androidBitmap, 0f, 0f, null)
    return androidBitmap
}