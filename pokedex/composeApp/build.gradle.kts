import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id("eunmin.compose.application")
    id("eunmin.compose.viewmodel")
    id("eunmin.compose.navigation")
    id("eunmin.koin")
}

val vCode = 1
val vName = "1.0.0"

android {
    defaultConfig {
        versionCode = vCode
        versionName = vName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.pokedex.feature)
        implementation(projects.pokedex.domain)
        implementation(projects.pokedex.data)
        implementation(projects.pokedex.remote)

        implementation(projects.shared.design)
    }
}

compose.desktop {
    application {
        mainClass = "io.eunmin.multiplatform.pokedex.composeApp.PokedexMainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.eunmin.multiplatform.pokedex.composeApp"
            packageVersion = vName
        }
    }
}