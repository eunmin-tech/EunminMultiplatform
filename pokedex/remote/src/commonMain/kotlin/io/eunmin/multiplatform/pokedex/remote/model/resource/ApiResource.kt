package io.eunmin.multiplatform.pokedex.remote.model.resource

import kotlinx.serialization.Serializable

@Serializable
internal data class ApiResource(
    val url: String
)

@Serializable
internal data class NamedApiResource(
    val name: String,
    val url: String
)

internal interface ResourceSummaryList<out T> {
    val count: Int
    val next: String?
    val previous: String?
    val results: List<T>
}

@Serializable
internal data class NamedApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<NamedApiResource>
): ResourceSummaryList<NamedApiResource>

@Serializable
internal data class ApiResourceList(
    override val count: Int,
    override val next: String?,
    override val previous: String?,
    override val results: List<ApiResource>
): ResourceSummaryList<ApiResource>