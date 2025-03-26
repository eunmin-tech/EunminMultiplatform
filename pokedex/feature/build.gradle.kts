plugins {
    id("eunmin.compose.library")
    id("eunmin.compose.viewmodel")
    id("eunmin.compose.navigation")
    id("eunmin.koin")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.base.feature)
        implementation(projects.pokedex.domain)
        implementation(libs.paging.compose.common)
    }
}