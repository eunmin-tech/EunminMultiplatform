package io.eunmin.multiplatform.pokedex.composeApp

import androidx.compose.ui.window.ComposeUIViewController
import io.eunmin.multiplatform.pokedex.navigation.PokedexApp

fun MainViewController() = ComposeUIViewController(
    configure = { enforceStrictPlistSanityCheck = false }
) { PokedexApp() }