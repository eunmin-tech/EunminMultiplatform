package io.eunmin.multiplatform.pokedex.domain.model.enums

enum class PokemonType {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY,
    STELLAR,
    UNKNOWN,
    SHADOW;

    companion object {
        fun fromString(value: String): PokemonType = when (value) {
            "normal" -> NORMAL
            "fighting" -> FIGHTING
            "flying" -> FLYING
            "poison" -> POISON
            "ground" -> GROUND
            "rock" -> ROCK
            "bug" -> BUG
            "ghost" -> GHOST
            "steel" -> STEEL
            "fire" -> FIRE
            "water" -> WATER
            "grass" -> GRASS
            "electric" -> ELECTRIC
            "psychic" -> PSYCHIC
            "ice" -> ICE
            "dragon" -> DRAGON
            "dark" -> DARK
            "fairy" -> FAIRY
            "stellar" -> STELLAR
            "shadow" -> SHADOW
            else -> UNKNOWN
        }
    }
}