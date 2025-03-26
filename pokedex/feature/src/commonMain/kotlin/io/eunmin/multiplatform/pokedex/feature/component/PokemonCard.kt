package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import coil3.compose.AsyncImage
import com.kmpalette.extensions.network.rememberNetworkDominantColorState
import com.kmpalette.loader.ImageBitmapLoader
import com.kmpalette.rememberPainterDominantColorState
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import io.github.aakira.napier.Napier
import io.ktor.http.Url
import kotlinx.coroutines.launch

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    val dominantColorState = rememberNetworkDominantColorState(
        defaultColor = MaterialTheme.colorScheme.surfaceVariant,
        defaultOnColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

    LaunchedEffect(pokemonSummary.imageUrl) {
        dominantColorState.updateFrom(Url(pokemonSummary.imageUrl))
    }

    Napier.v { "${pokemonSummary.name} ${dominantColorState.result.toString()}" }

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        onClick = { onClick(pokemonSummary) },
        colors = CardColors(
            containerColor = dominantColorState.color,
            contentColor = dominantColorState.onColor,
            disabledContainerColor = dominantColorState.color,
            disabledContentColor = dominantColorState.onColor,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally),
            model = pokemonSummary.imageUrl,
            contentDescription = pokemonSummary.name,
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = pokemonSummary.name,
        )
    }
}
