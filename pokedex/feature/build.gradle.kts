plugins {
    id("eunmin.multiplatform.library")
    id("eunmin.compose")
    id("eunmin.compose.viewmodel")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.domain)
        implementation(libs.paging.compose)
    }
}