package io.eunmin.multiplatform.pokedex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.eunmin.multiplatform.design.system.EunminTheme
import io.eunmin.multiplatform.pokedex.data.di.pokedexDataModules
import io.eunmin.multiplatform.pokedex.domain.di.pokedexDomainModules
import io.eunmin.multiplatform.pokedex.feature.di.pokedexFeatureModules
import io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list.PokemonListRoute
import io.eunmin.multiplatform.pokedex.remote.di.pokedexRemoteModules
import io.github.aakira.napier.Napier
import org.koin.compose.KoinApplication

@Composable
fun PokedexApp() {
    KoinApplication(
        application = { modules(
            pokedexFeatureModules,
            pokedexDomainModules,
            pokedexDataModules,
            pokedexRemoteModules
        ) }
    ) {

        EunminTheme {
            Scaffold { padding ->
                Box(
                    modifier = Modifier.padding(padding)
                ) {
                    PokemonListRoute(
                        onPokemonCardClicked = {  }
                    )
                }
            }
        }
    }
}