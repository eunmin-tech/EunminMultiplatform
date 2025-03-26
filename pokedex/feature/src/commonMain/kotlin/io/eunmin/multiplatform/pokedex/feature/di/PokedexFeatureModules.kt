package io.eunmin.multiplatform.pokedex.feature.di

import io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list.PokemonListScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val pokedexFeatureModules = module {
    viewModelOf(::PokemonListScreenViewModel)
}