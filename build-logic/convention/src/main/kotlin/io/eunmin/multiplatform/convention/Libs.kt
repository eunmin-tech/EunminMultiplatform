package io.eunmin.multiplatform.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs
    get(): VersionCatalog = extensions.getByType(VersionCatalogsExtension::class).named("libs")

internal fun String.androidPackageName() =
    split(":").drop(1).joinToString(".").replace("-", ".")

internal fun String.iosModuleName() =
    split(":").drop(1).joinToString("") {
        it.split("-").joinToString("") { module ->
            module.replaceFirstChar { char -> char.uppercaseChar() }
        }.replaceFirstChar { char -> char.uppercaseChar() }
    }