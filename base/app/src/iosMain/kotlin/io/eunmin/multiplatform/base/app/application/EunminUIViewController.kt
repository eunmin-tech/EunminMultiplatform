package io.eunmin.multiplatform.base.app.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController

fun EunminUIViewController(content: @Composable () -> Unit) = ComposeUIViewController(
    configure = { enforceStrictPlistSanityCheck = false }
) {
    EunminInit.init()
    content()
}