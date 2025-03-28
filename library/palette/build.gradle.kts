plugins {
    id("eunmin.compose.library")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.palette)
    }
}