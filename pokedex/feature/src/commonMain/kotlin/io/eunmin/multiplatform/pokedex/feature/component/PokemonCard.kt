package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kmpalette.extensions.network.rememberNetworkDominantColorState
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import io.ktor.http.Url

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    val dominantColorState = rememberNetworkDominantColorState(
        defaultColor = MaterialTheme.colorScheme.surfaceVariant,
        defaultOnColor = MaterialTheme.colorScheme.onSurfaceVariant
    )

    LaunchedEffect(pokemonSummary.imageUrl) {
        dominantColorState.updateFrom(Url(pokemonSummary.imageUrl))
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onClick(pokemonSummary) },
        colors = CardDefaults.cardColors(
            containerColor = dominantColorState.color,
            contentColor = dominantColorState.onColor,
            disabledContainerColor = dominantColorState.color,
            disabledContentColor = dominantColorState.onColor,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 2.dp)
                .padding(top = 2.dp),
            model = pokemonSummary.imageUrl,
            contentDescription = pokemonSummary.name,
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(horizontal = 2.dp)
                .padding(bottom = 2.dp),
            text = pokemonSummary.name,
        )
    }
}
