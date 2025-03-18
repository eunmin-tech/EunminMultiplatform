package io.eunmin.multiplatform.pokedex.data.datasource

import io.eunmin.multiplatform.pokedex.data.model.PageEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonSummaryEntity

interface PokemonRemoteDataSource {
    suspend fun fetchPokemonList(page: Int, size: Int): PageEntity<PokemonSummaryEntity>
    suspend fun fetchPokemon(id: Int): PokemonEntity
}