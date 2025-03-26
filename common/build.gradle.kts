plugins {
    id("eunmin.multiplatform.library")
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(libs.napier)
    }
}