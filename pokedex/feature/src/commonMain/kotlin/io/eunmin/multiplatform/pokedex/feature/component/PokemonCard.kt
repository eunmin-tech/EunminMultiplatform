package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.kmpalette.rememberDominantColorState
import io.eunmin.multiplatform.design.extensions.asImageBitmap
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import kotlinx.coroutines.launch

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val dominantColorState = rememberDominantColorState(
        defaultColor = MaterialTheme.colorScheme.surfaceVariant,
        defaultOnColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

    ElevatedCard(
        modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(2.dp),
        onClick = { onClick(pokemonSummary) },
        colors = CardDefaults.cardColors(
            containerColor = dominantColorState.color,
            contentColor = dominantColorState.onColor,
            disabledContainerColor = dominantColorState.color,
            disabledContentColor = dominantColorState.onColor,
        ),
    ) {
        val platformContext = LocalPlatformContext.current
        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            model = ImageRequest.Builder(platformContext)
                .data(pokemonSummary.imageUrl)
                .listener(
                    onSuccess = { _, result ->
                        coroutineScope.launch {
                            dominantColorState.updateFrom(result.image.asImageBitmap())
                        }
                    }
                )
                .build(),
            contentDescription = pokemonSummary.name
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = pokemonSummary.name,
        )
    }
}
