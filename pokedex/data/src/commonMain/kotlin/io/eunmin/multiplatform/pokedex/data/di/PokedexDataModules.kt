package io.eunmin.multiplatform.pokedex.data.di

import io.eunmin.multiplatform.pokedex.data.impl.PokemonRepositoryImpl
import io.eunmin.multiplatform.pokedex.domain.repository.PokemonRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val pokedexDataModules = module {
    singleOf(::PokemonRepositoryImpl) bind PokemonRepository::class
}