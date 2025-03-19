package io.eunmin.multiplatform.pokedex.remote.mapper

import io.eunmin.multiplatform.pokedex.data.model.PageEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonSummaryEntity
import io.eunmin.multiplatform.pokedex.remote.model.PokemonResponse
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResource
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResourceList

internal fun <R> NamedApiResourceList.toEntity(transform: (NamedApiResource) -> R) = PageEntity(
    count = count,
    next = next,
    previous = previous,
    results = results.map(transform)
)

internal fun NamedApiResource.toPokemonIdEntity() = PokemonSummaryEntity(
    name = name,
    url = url
)

internal fun PokemonResponse.toEntity() = PokemonEntity(
    id = id,
    name = name,
    types = types.map { it.type.name }
)
