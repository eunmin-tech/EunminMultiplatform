package io.eunmin.multiplatform.pokedex.composeApp

import io.eunmin.multiplatform.base.app.application.eunminApplication
import io.eunmin.multiplatform.pokedex.navigation.PokedexApp

fun main() = eunminApplication(
    title = "Pokedex",
) {
    PokedexApp()
}