package io.eunmin.multiplatform.pokedex.remote.di

import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.remote.api.PokemonApi
import io.eunmin.multiplatform.pokedex.remote.impl.PokemonRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val pokedexRemoteModules = module {
    singleOf(::PokemonRemoteDataSourceImpl) bind PokemonRemoteDataSource::class
    singleOf(::PokemonApi)
}