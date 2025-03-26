package io.eunmin.multiplatform.pokedex.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import io.eunmin.multiplatform.design.system.EunminTheme
import io.eunmin.multiplatform.pokedex.data.di.pokedexDataModules
import io.eunmin.multiplatform.pokedex.domain.di.pokedexDomainModules
import io.eunmin.multiplatform.pokedex.feature.di.pokedexFeatureModules
import io.eunmin.multiplatform.pokedex.feature.ui.pokemon_list.PokemonListRoute
import io.eunmin.multiplatform.pokedex.remote.di.pokedexRemoteModules
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
            Surface {
                PokemonListRoute(
                    onPokemonCardClicked = {  }
                )
            }
        }
    }
}