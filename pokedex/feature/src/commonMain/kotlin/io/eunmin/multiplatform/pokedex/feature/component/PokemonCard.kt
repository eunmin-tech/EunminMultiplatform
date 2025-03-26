package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.asPainter
import coil3.request.ImageRequest
import coil3.toBitmap
import com.kmpalette.color
import com.kmpalette.extensions.network.rememberNetworkPaletteState
import com.kmpalette.loader.rememberNetworkLoader
import com.kmpalette.loader.rememberPainterLoader
import com.kmpalette.rememberDominantColorState
import com.kmpalette.rememberPainterPaletteState
import com.kmpalette.rememberPaletteState
import io.eunmin.multiplatform.design.extensions.androidAllowHardware
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import io.github.aakira.napier.Napier
import io.ktor.http.Url
import kotlinx.coroutines.launch

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    val platformContext = LocalPlatformContext.current

    val paletteState = rememberPaletteState(rememberNetworkLoader())
    val lifecycleOwner = LocalLifecycleOwner.current

    Card(
        onClick = { onClick(pokemonSummary) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(
                paletteState.state?.paletteOrNull?.dominantSwatch?.color?: MaterialTheme.colorScheme.onPrimary
            ),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(platformContext)
                    .data(pokemonSummary.imageUrl)
                    .listener(
                        onSuccess = { _, _ ->
                            lifecycleOwner.lifecycleScope.launch {
                                paletteState.generate(Url(pokemonSummary.imageUrl))
                            }
                        }
                    )
                    .build(),
                contentDescription = pokemonSummary.name,
            )
        }
    }
}
