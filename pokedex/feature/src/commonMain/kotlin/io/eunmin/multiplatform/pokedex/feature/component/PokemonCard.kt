package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import coil3.compose.AsyncImage
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    Card(
        onClick = { onClick(pokemonSummary) },
    ) {
        AsyncImage(
            model = pokemonSummary.imageUrl,
            contentDescription = pokemonSummary.name
        )
    }
}
