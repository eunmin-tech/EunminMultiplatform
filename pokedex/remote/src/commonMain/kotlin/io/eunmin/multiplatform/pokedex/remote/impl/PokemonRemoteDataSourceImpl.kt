package io.eunmin.multiplatform.pokedex.remote.impl

import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.data.model.PageEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonIdEntity
import io.eunmin.multiplatform.pokedex.data.remote.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.remote.api.PokemonApi
import io.eunmin.multiplatform.pokedex.remote.mapper.toEntity
import io.eunmin.multiplatform.pokedex.remote.mapper.toPokemonIdEntity
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResource

internal class PokemonRemoteDataSourceImpl(
    private val api: PokemonApi
): PokemonRemoteDataSource {
    override suspend fun getPokemonIds(page: Int, size: Int): PageEntity<PokemonIdEntity> =
        api.getPokemons(page, size).toEntity(NamedApiResource::toPokemonIdEntity)

    override suspend fun getPokemonDetail(id: Int): PokemonEntity =
        api.getPokemonDetail(id).toEntity()

}