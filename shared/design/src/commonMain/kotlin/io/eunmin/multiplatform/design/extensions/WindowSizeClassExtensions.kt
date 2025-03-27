package io.eunmin.multiplatform.design.extensions

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable

@Composable
expect fun calculateWindowSizeClass(): WindowSizeClass