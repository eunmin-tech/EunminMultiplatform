package io.eunmin.multiplatform.pokedex.domain.model

import io.eunmin.multiplatform.pokedex.domain.model.enums.PokemonType

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<PokemonType>,
)
