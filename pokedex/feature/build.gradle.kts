plugins {
    id("eunmin.multiplatform.library")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.domain)
    }
}