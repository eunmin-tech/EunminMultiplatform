plugins {
    id("eunmin.multiplatform.application")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.feature)
        implementation(projects.pokedex.domain)
        implementation(projects.pokedex.data)
        implementation(projects.pokedex.remote)
    }
}