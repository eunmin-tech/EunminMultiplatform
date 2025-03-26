package io.eunmin.multiplatform.pokedex.feature.model

import androidx.compose.runtime.Immutable

@Immutable
data class PokemonSummaryModel(
    val id: Int,
    val name: String,
    val imageUrl: String
)
