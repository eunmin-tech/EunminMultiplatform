package io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel

@Composable
fun PokemonListScreen(
    pokemonSummaries: LazyPagingItems<PokemonSummaryModel>,
    onPokemonCardClicked: (Int) -> Unit
) {
    LazyColumn {
        items(count = pokemonSummaries.) { pokemonSummary ->
            PokemonCard(
                pokemonSummary = pokemonSummary,
                onClick = { onPokemonCardClicked(pokemonSummary.id) }
            )
        }
    }
}