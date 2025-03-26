plugins {
    id("eunmin.compose.application")
    id("eunmin.compose.viewmodel")
    id("eunmin.compose.navigation")
    id("eunmin.koin")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.feature)
        implementation(projects.pokedex.domain)
        implementation(projects.pokedex.data)
        implementation(projects.pokedex.remote)

        implementation(projects.shared.design)
    }
}