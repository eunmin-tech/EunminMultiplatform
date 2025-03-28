package io.eunmin.multiplatform.base.app.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun eunminApplication(
    title: String,
    content: @Composable () -> Unit
) = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = title,
    ) {
        EunminInit.init()
        content()
    }
}