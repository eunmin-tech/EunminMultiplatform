plugins {
    id("eunmin.multiplatform.library")
    id("eunmin.compose.viewmodel")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.shared.dataResource)
    }
}