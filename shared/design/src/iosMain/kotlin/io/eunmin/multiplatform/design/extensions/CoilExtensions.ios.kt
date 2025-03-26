package io.eunmin.multiplatform.design.extensions

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.asSkiaBitmap
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import coil3.Bitmap
import coil3.request.ImageRequest

actual fun ImageRequest.Builder.androidAllowHardware(b: Boolean): ImageRequest.Builder = this
actual fun createImageBitmap(
    width: Int,
    height: Int
): ImageBitmap = ImageBitmap(width, height, ImageBitmapConfig.Argb8888)

actual fun Painter.drawBitmap(bitmap: ImageBitmap, width: Int, height: Int, density: Density, layoutDirection: LayoutDirection): Bitmap {
    val canvas = Canvas(bitmap)
    val floatSize = Size(width.toFloat(), height.toFloat())

    CanvasDrawScope().draw(
        density = density,
        layoutDirection = layoutDirection,
        canvas = canvas,
        size = floatSize
    ) {
        draw(floatSize)
    }
    return bitmap.asSkiaBitmap()
}