plugins {
    id("eunmin.multiplatform.library")
    id("eunmin.ktor")
    id("eunmin.koin")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.data)

        implementation(libs.paging.runtime)
    }
}