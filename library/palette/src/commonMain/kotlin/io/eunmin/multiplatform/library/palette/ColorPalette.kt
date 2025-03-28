package io.eunmin.multiplatform.library.palette

import androidx.compose.runtime.compositionLocalOf
import coil3.Bitmap
import com.kmpalette.rememberPainterDominantColorState
import com.kmpalette.rememberPainterPaletteState

data class ColorPaletteModel(
    val dominantColor: Int,
    val vibrantColor: Int,
    val mutedColor: Int,
    val darkVibrantColor: Int,
    val darkMutedColor: Int,
    val lightVibrantColor: Int,
    val lightMutedColor: Int
)

object ColorPalette {
    fun from(bitmap: Bitmap, onGenerated: (ColorPaletteModel) -> Unit) {
        extractPaletteFromPainter(bitmap, onGenerated)
    }
}

expect fun extractPaletteFromPainter(bitmap: Bitmap, onGenerated: (ColorPaletteModel) -> Unit)


fun Test() {
    rememberPainterPaletteState {  }()
}