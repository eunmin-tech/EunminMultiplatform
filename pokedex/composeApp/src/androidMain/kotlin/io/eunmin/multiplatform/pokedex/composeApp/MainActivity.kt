package io.eunmin.multiplatform.pokedex.composeApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.eunmin.multiplatform.pokedex.navigation.PokedexApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    PokedexApp()
}