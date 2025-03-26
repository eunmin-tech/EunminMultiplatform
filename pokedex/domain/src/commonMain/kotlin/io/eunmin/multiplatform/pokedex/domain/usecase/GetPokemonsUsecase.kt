package io.eunmin.multiplatform.pokedex.domain.usecase

import io.eunmin.multiplatform.pokedex.domain.repository.PokemonRepository

class GetPokemonsUsecase(
    private val repository: PokemonRepository
) {
    operator fun invoke(size: Int) = repository.getPokemons(size)
}