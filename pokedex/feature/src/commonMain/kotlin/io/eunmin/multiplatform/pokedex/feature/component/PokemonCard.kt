package io.eunmin.multiplatform.pokedex.feature.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kmpalette.extensions.network.rememberNetworkDominantColorState
import com.kmpalette.rememberPainterDominantColorState
import io.eunmin.multiplatform.common.constants.EunminConstants
import io.eunmin.multiplatform.common.enums.DeviceType
import io.eunmin.multiplatform.pokedex.feature.model.PokemonSummaryModel
import io.github.aakira.napier.Napier
import io.ktor.http.Url
import kotlinx.coroutines.launch

@Composable
fun PokemonCard(
    pokemonSummary: PokemonSummaryModel,
    onClick: (PokemonSummaryModel) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    val colorState = remember { Ma }

    Napier.v { "${pokemonSummary.name} : ${dominantColorState.result?.paletteOrNull?.swatches.toString()}" }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(2.dp),
        onClick = { onClick(pokemonSummary) },
        colors = CardDefaults.cardColors(
            containerColor = dominantColorState.color,
            contentColor = dominantColorState.onColor,
            disabledContainerColor = dominantColorState.color,
            disabledContentColor = dominantColorState.onColor,
        ),
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            model = pokemonSummary.imageUrl,
            contentDescription = pokemonSummary.name,
            onSuccess = {
                if (EunminConstants.deviceType != DeviceType.ANDROID) {
                    coroutineScope.launch {
                        painterColorState.updateFrom(it.painter)
                    }
                }
            }
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = pokemonSummary.name,
        )
    }
}
