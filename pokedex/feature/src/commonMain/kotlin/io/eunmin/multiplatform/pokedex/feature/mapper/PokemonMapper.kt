package io.eunmin.multiplatform.pokedex.feature.mapper

import io.eunmin.multiplatform.pokedex.domain.model.PokemonSummary
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel

internal fun PokemonSummary.toModel() = PokemonSummaryModel(
    id = id,
    name = name,
    imageUrl = imageUrl
)