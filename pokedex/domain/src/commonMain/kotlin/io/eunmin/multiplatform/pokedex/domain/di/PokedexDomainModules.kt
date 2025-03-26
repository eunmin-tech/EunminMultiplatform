package io.eunmin.multiplatform.pokedex.domain.di

import io.eunmin.multiplatform.pokedex.domain.usecase.GetPokemonUsecase
import io.eunmin.multiplatform.pokedex.domain.usecase.GetPokemonsUsecase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val pokedexDomainModules = module {
    singleOf(::GetPokemonsUsecase)
    singleOf(::GetPokemonUsecase)
}