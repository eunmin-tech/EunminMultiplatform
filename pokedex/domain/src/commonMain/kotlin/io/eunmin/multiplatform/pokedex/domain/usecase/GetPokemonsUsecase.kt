package io.eunmin.multiplatform.pokedex.domain.usecase

import io.eunmin.multiplatform.pokedex.domain.repository.PokemonRepository

class GetPokemonsUsecase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke() = repository.getPokemons()
}