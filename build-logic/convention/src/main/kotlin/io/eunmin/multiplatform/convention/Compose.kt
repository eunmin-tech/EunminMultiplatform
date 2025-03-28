package io.eunmin.multiplatform.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureApplicationCompose() {
    configureMultiplatformCompose()
    extensions.configure<ApplicationExtension> {
        buildFeatures.compose = true
    }
}

internal fun Project.configureLibraryCompose() {
    configureMultiplatformCompose()
    extensions.configure<LibraryExtension> {
        buildFeatures.compose = true
    }
}

internal fun Project.configureMultiplatformCompose() {
    with(pluginManager) {
        apply("org.jetbrains.compose")
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    val compose = extensions.getByType<ComposeExtension>().dependencies

    extensions.configure<KotlinMultiplatformExtension> {
        sourceSets.androidMain.dependencies {
            implementation(compose.preview)
            implementation("androidx.window:window:1.3.0")
            implementation(libs.findLibrary("androidx-activity-compose").get())
        }

        sourceSets.commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.material3AdaptiveNavigationSuite)
            implementation(compose.foundation)

            implementation(compose.animationGraphics)
            implementation(libs.findBundle("coil").get())
            implementation(libs.findBundle("compose-adaptive").get())
            if (!name.contains("design")) {
                implementation(project(":shared:design"))
            }
            if (!path.contains("library")) {
                implementation(project(":library:palette"))
            }
        }

        sourceSets["desktopMain"].dependencies {
            implementation(compose.desktop.currentOs)
        }
    }

    dependencies {
        "debugImplementation"(compose.uiTooling)
    }

}