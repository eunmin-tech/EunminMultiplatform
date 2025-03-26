package io.eunmin.multiplatform.pokedex.data.mapper

import io.eunmin.multiplatform.common.extensions.urlToId
import io.eunmin.multiplatform.pokedex.data.model.PokemonEntity
import io.eunmin.multiplatform.pokedex.data.model.PokemonSummaryEntity
import io.eunmin.multiplatform.pokedex.domain.model.Pokemon
import io.eunmin.multiplatform.pokedex.domain.model.PokemonSummary
import io.eunmin.multiplatform.pokedex.domain.model.enums.PokemonType

internal fun PokemonSummaryEntity.toDomain(): PokemonSummary {
    val id = url.urlToId()
    return PokemonSummary(
        id = id,
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    )
}

internal fun PokemonEntity.toDomain(): Pokemon = Pokemon(
    id = id,
    name = name,
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png",
    types = types.map { PokemonType.fromString(it) }
)