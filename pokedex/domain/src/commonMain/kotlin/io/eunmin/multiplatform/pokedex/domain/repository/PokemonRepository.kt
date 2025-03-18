package io.eunmin.multiplatform.pokedex.domain.repository

import androidx.paging.PagingData
import io.eunmin.multiplatform.data_resource.DataResource
import io.eunmin.multiplatform.pokedex.domain.model.Pokemon
import io.eunmin.multiplatform.pokedex.domain.model.PokemonSummary
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemons(page: Int, size: Int): Flow<PagingData<PokemonSummary>>
    suspend fun getPokemon(id: Int): Flow<DataResource<Pokemon>>
}