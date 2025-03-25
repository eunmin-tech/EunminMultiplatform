package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    Card(
        onClick = { onClick(pokemonSummary) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = pokemonSummary.imageUrl,
                contentDescription = pokemonSummary.name
            )
        }

    }
}
