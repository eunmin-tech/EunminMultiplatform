package io.eunmin.multiplatform.pokedex.domain.usecase

import io.eunmin.multiplatform.pokedex.domain.repository.PokemonRepository

class GetPokemonUsecase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(id: Int) = repository.getPokemon(id)
}