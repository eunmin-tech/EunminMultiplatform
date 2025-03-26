package io.eunmin.multiplatform.pokedex.data.model

data class PokemonEntity(
    val id: Int,
    val name: String,
    val types: List<String>
)
