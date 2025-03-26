plugins {
    `kotlin-dsl`
}

group = "io.eunmin.multiplatform.build.convention"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("Application") {
            id = "eunmin.multiplatform.application"
            implementationClass = "MultiplatformApplicationConvention"
        }
        register("Library") {
            id = "eunmin.multiplatform.library"
            implementationClass = "MultiplatformLibraryConvention"
        }

        register("ComposeApplication") {
            id = "eunmin.compose.application"
            implementationClass = "ComposeMultiplatformApplicationConvention"
        }
        register("ComposeLibrary") {
            id = "eunmin.compose.library"
            implementationClass = "ComposeMultiplatformLibraryConvention"
        }
        register("ComposeNavigation") {
            id = "eunmin.compose.navigation"
            implementationClass = "ComposeNavigationConvention"
        }
        register("ComposeViewmodel") {
            id = "eunmin.compose.viewmodel"
            implementationClass = "ComposeViewModelConvention"
        }

        register("Koin") {
            id = "eunmin.koin"
            implementationClass = "KoinConvention"
        }
        register("Ktor") {
            id = "eunmin.ktor"
            implementationClass = "KtorConvention"
        }
    }
}