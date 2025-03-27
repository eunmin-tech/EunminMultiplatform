package io.eunmin.multiplatform.pokedex.composeApp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.eunmin.multiplatform.pokedex.navigation.PokedexApp
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Pokedex",
    ) {
        Napier.base(DebugAntilog())
        PokedexApp()
    }
}