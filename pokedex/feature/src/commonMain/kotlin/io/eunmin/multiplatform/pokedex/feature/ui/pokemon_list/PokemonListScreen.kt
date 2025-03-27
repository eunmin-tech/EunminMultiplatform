package io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import app.cash.paging.compose.itemKey
import io.eunmin.multiplatform.design.component.EunminTopAppBar
import io.eunmin.multiplatform.design.extensions.calculateWindowSizeClass
import io.eunmin.multiplatform.pokedex.feature.component.PokemonCard
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import kotlinx.coroutines.launch
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    pokemonSummaries: LazyPagingItems<PokemonSummaryModel>,
    onPokemonCardClicked: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            EunminTopAppBar(title = { Text("Pokedex") })
        }
    ) { padding ->
        val windowWidthSizeClass = calculateWindowSizeClass()
        val gridCount = when (windowWidthSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 2
            WindowWidthSizeClass.Medium -> 3
            else -> 5
        }

        val gridScrollState = rememberLazyGridState()
        val coroutineScope = rememberCoroutineScope()
        Box {
            LazyVerticalGrid(
                modifier = Modifier.padding(padding).padding(horizontal = 16.dp),
                columns = GridCells.Fixed(gridCount),
                state = gridScrollState,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    count = pokemonSummaries.itemCount,
                    key = pokemonSummaries.itemKey { it.name },
                ) { index ->
                    val pokemonSummary = pokemonSummaries[index]!!
                    PokemonCard(
                        pokemonSummary = pokemonSummary,
                        onClick = { onPokemonCardClicked(pokemonSummary.id) }
                    )
                }
            }

            if (gridScrollState.canScrollBackward) {
                IconButton(
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .padding(50.dp),
                    onClick = { coroutineScope.launch { gridScrollState.animateScrollToItem(0) } },
                    colors = IconButtonDefaults.filledIconButtonColors()
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowUpward,
                        contentDescription = null
                    )
                }
            }
        }
    }
}