package io.eunmin.multiplatform.pokedex.remote.model

import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResource
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonResponse(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeResponse>,
)

@Serializable
internal data class PokemonTypeResponse(
    val slot: Int,
    val type: NamedApiResource
)
