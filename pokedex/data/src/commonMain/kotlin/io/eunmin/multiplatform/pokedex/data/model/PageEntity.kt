package io.eunmin.multiplatform.pokedex.data.model

data class PageEntity<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
