package io.eunmin.multiplatform.pokedex.remote.api

import io.eunmin.multiplatform.pokedex.remote.model.PokemonResponse
import io.eunmin.multiplatform.pokedex.remote.model.resource.NamedApiResourceList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class PokemonApi(
    private val client: HttpClient
) {
    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon"
    }

    suspend fun getPokemons(page: Int, size: Int): NamedApiResourceList =
        client.get(BASE_URL) {
            parameter("offset", (page - 1) * size)
            parameter("limit", size)
        }.body()

    suspend fun getPokemonDetail(id: Int): PokemonResponse =
        client.get("$BASE_URL/$id").body()
}
