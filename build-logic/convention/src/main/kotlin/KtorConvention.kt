import io.eunmin.multiplatform.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KtorConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<KotlinMultiplatformExtension> {
                sourceSets.apply {
                    commonMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-core").get())
                        implementation(libs.findLibrary("ktor-client-content-negotiation").get())
                        implementation(libs.findLibrary("ktor-client-json").get())
                        implementation(libs.findLibrary("ktor-client-logging").get())
                    }

                    androidMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-okhttp").get())
                    }

                    iosMain.dependencies {
                        implementation(libs.findLibrary("ktor-client-darwin").get())
                    }

                    get("desktopMain")?.dependencies {
                        implementation(libs.findLibrary("ktor-client-okhttp").get())
                    }
                }
            }
        }
    }
}