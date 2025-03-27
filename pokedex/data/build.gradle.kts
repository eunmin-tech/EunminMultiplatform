plugins {
    id("eunmin.multiplatform.library")
    id("eunmin.koin")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.domain)
        implementation(projects.shared.dataResource)

        implementation(libs.paging.common)
    }
}