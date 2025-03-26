package io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import app.cash.paging.compose.itemKey
import io.eunmin.multiplatform.pokedex.feature.component.PokemonCard
import io.github.aakira.napier.Napier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PokemonListRoute(
    onPokemonCardClicked: (Int) -> Unit,
    viewModel: PokemonListScreenViewModel = koinViewModel()
) {
    val pokemonSummaries by rememberUpdatedState(viewModel.pokemons.collectAsLazyPagingItems())

    PokemonListScreen(
        pokemonSummaries = pokemonSummaries,
        onPokemonCardClicked = onPokemonCardClicked
    )
}

@Composable
fun PokemonListScreen(
    pokemonSummaries: LazyPagingItems<PokemonSummaryModel>,
    onPokemonCardClicked: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            count = pokemonSummaries.itemCount,
            key = pokemonSummaries.itemKey { it.id },
            span = { GridItemSpan(1) }
        ) { index ->
            val pokemonSummary = pokemonSummaries[index]!!
            PokemonCard(
                pokemonSummary = pokemonSummary,
                onClick = { onPokemonCardClicked(pokemonSummary.id) }
            )
        }
    }
}