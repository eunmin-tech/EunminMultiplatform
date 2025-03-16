rootProject.name = "Eunmin"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(
    ":common",

    ":shared:design", ":shared:data-resource",
)

//addProjectModules("pokedex")
//addProjectModules("portfolio")

val modules = listOf(
    ":androidApp", ":feature", ":domain", ":data", ":local", ":remote", ":resources"
)

fun addProjectModules(name: String) {
    include(modules.map { ":$name:$it" }.onEach { println(it) })
}