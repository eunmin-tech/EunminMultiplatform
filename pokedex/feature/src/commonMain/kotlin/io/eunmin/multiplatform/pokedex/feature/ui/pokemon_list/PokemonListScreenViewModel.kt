package io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import io.eunmin.multiplatform.base.feature.viewmodel.BaseViewModel
import io.eunmin.multiplatform.pokedex.domain.model.PokemonSummary
import io.eunmin.multiplatform.pokedex.domain.usecase.GetPokemonsUsecase
import io.eunmin.multiplatform.pokedex.feature.mapper.toModel
import kotlinx.coroutines.flow.map

class PokemonListScreenViewModel(
    getPokemonsUsecase: GetPokemonsUsecase
): BaseViewModel<PokemonListScreenSideEffect>() {
    val pokemons = getPokemonsUsecase(20)
        .cachedIn(viewModelScope)
        .map { it.map(PokemonSummary::toModel) }
}