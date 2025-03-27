import io.eunmin.multiplatform.convention.configureApplicationCompose
import io.eunmin.multiplatform.convention.configureMultiplatformApplication
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiplatformApplicationConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureMultiplatformApplication()
            configureApplicationCompose()
        }
    }
}