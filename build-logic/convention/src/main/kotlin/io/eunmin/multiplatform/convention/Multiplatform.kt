package io.eunmin.multiplatform.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureMultiplatformApplication() {
    with(pluginManager) {
        apply("com.android.application")
    }
    configureMultiplatformCommon()

    extensions.configure<ApplicationExtension> {
        configureAndroid(this)
        defaultConfig.targetSdk = libs.findVersion("android-sdk-target").get().requiredVersion.toInt()
    }

    extensions.configure<KotlinMultiplatformExtension> {
        androidTarget()

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = project.path.iosModuleName()
                isStatic = true
            }
        }

        configureMultiplatformKotlin(this)
    }
}

internal fun Project.configureMultiplatformLibrary() {
    with(pluginManager) {
        apply("com.android.library")
    }
    configureMultiplatformCommon()

    extensions.configure<LibraryExtension> {
        configureAndroid(this)
    }

    extensions.configure<KotlinMultiplatformExtension> {
        androidTarget()

        iosX64()
        iosArm64()
        iosSimulatorArm64()

        configureMultiplatformKotlin(this)
    }
}

private fun Project.configureMultiplatformCommon() {
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
        apply("org.jetbrains.kotlin.plugin.serialization")
    }
}

private fun Project.configureMultiplatformKotlin(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    jvmToolchain(21)

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    sourceSets.apply {
        commonMain.dependencies {
            implementation(libs.findLibrary("kotlin-coroutines-core").get())
            implementation(libs.findLibrary("kotlin-datetime").get())
            implementation(libs.findLibrary("kotlin-serialization-json").get())

            if (!name.contains("common")) {
                sourceSets.commonMain.dependencies {
                    implementation(project(":common"))
                }
            }
        }
    }
}

private fun Project.configureAndroid(
    extension: CommonExtension<*, *, *, *, *, *>
) = extension.apply {
    namespace = "io.eunmin.multiplatform.${path.androidPackageName()}"

    compileSdk = libs.findVersion("android-sdk-compile").get().requiredVersion.toInt()
    defaultConfig {
        minSdk = libs.findVersion("android-sdk-min").get().requiredVersion.toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
}
