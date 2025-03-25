import io.eunmin.multiplatform.convention.configureMultiplatformApplication
import io.eunmin.multiplatform.convention.configureMultiplatformCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiplatformApplicationConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureMultiplatformApplication()
            configureMultiplatformCompose()
        }
    }
}