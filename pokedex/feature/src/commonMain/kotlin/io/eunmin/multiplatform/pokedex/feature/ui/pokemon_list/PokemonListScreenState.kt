package io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list

import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel

data class PokemonListScreenState(
    val isLoading: Boolean = false,
    val pokemons: List<PokemonSummaryModel> = emptyList()
)
