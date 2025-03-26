package io.eunmin.multiplatform.pokedex.data.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import io.eunmin.multiplatform.base.data.bound.flowDataResource
import io.eunmin.multiplatform.data_resource.DataResource
import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.data.mapper.toDomain
import io.eunmin.multiplatform.pokedex.data.pagingsource.PokemonSummaryPagingSource
import io.eunmin.multiplatform.pokedex.domain.model.Pokemon
import io.eunmin.multiplatform.pokedex.domain.model.PokemonSummary
import io.eunmin.multiplatform.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource
): PokemonRepository {
    override fun getPokemons(size: Int): Flow<PagingData<PokemonSummary>> =
        Pager(
            config = PagingConfig(pageSize = size),
            pagingSourceFactory = { PokemonSummaryPagingSource(remoteDataSource) }
        ).flow.map { data -> data.map { it.toDomain() } }

    override suspend fun getPokemon(id: Int): Flow<DataResource<Pokemon>> = flowDataResource(
        dataAction = { remoteDataSource.fetchPokemon(id) },
        mapper = { it.toDomain() }
    )
}