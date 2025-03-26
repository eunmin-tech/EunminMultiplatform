package io.eunmin.multiplatform.pokedex.remote.impl

import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.data.model.PageEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonSummaryEntity
import io.eunmin.multiplatform.pokedex.remote.api.PokemonApi
import io.eunmin.multiplatform.pokedex.remote.mapper.toEntity
import io.eunmin.multiplatform.pokedex.remote.mapper.toPokemonIdEntity
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResource

internal class PokemonRemoteDataSourceImpl(
    private val api: PokemonApi
): PokemonRemoteDataSource {
    override suspend fun fetchPokemonList(page: Int, size: Int): PageEntity<PokemonSummaryEntity> =
        api.getPokemons(page, size).toEntity(NamedApiResource::toPokemonIdEntity)

    override suspend fun fetchPokemon(id: Int): PokemonEntity =
        api.getPokemonDetail(id).toEntity()

}