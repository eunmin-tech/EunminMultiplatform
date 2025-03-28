plugins {
    id("eunmin.multiplatform.library")
}
android {
    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(libs.napier)
    }
}