package io.eunmin.multiplatform.design.extensions

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import coil3.Bitmap
import coil3.request.ImageRequest
import kotlin.math.roundToInt

expect fun ImageRequest.Builder.androidAllowHardware(b: Boolean): ImageRequest.Builder

expect fun createImageBitmap(width: Int, height: Int): ImageBitmap

expect fun Painter.drawBitmap(bitmap: ImageBitmap, width: Int, height: Int, density: Density, layoutDirection: LayoutDirection): Bitmap

fun Painter.asBitmap(
    width: Int = intrinsicSize.width.roundToInt(),
    height: Int = intrinsicSize.height.roundToInt(),
    density: Density,
    layoutDirection: LayoutDirection,
): ImageBitmap {
    val bitmap = createImageBitmap(width, height)
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

    return bitmap
}