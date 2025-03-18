package io.eunmin.multiplatform.pokedex.remote.mapper

import io.eunmin.multiplatform.pokedex.common.enums.PokemonType
import io.eunmin.multiplatform.pokedex.data.model.PageEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonIdEntity
import io.eunmin.multiplatform.pokedex.remote.model.PokemonResponse
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResource
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResourceList

internal fun <R> NamedApiResourceList.toEntity(transform: (NamedApiResource) -> R) = PageEntity(
    count = count,
    next = next,
    previous = previous,
    results = results.map(transform)
)

internal fun NamedApiResource.toPokemonIdEntity() = PokemonIdEntity(
    id = "/-?[0-9]+/$".toRegex().find(url)!!.value.filter { it.isDigit() || it == '-' }.toInt()
)

internal fun PokemonResponse.toEntity() = PokemonEntity(
    id = id,
    name = name,
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png",
    types = types.map { PokemonType.valueOf(it.type.name) }
)
