import io.eunmin.multiplatform.convention.configureLibraryCompose
import io.eunmin.multiplatform.convention.configureMultiplatformLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiplatformLibraryConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureMultiplatformLibrary()
            configureLibraryCompose()
        }
    }
}