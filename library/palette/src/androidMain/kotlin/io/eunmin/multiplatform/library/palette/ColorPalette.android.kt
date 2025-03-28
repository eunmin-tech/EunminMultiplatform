package io.eunmin.multiplatform.library.palette

import androidx.compose.ui.graphics.asImageBitmap
import coil3.Bitmap
import com.kmpalette.palette.graphics.Palette

actual fun extractPaletteFromPainter(bitmap: Bitmap, onGenerated: (ColorPaletteModel) -> Unit) {
    val palette = Palette.from(bitmap.asImageBitmap()).generate()
    onGenerated(
        ColorPaletteModel(
            dominantColor = palette.getDominantColor(0),
            vibrantColor = palette.getVibrantColor(0),
            mutedColor = palette.getMutedColor(0),
            darkVibrantColor = palette.getDarkVibrantColor(0),
            darkMutedColor = palette.getDarkMutedColor(0),
            lightVibrantColor = palette.getLightVibrantColor(0),
            lightMutedColor = palette.getLightMutedColor(0)
        )
    )
}