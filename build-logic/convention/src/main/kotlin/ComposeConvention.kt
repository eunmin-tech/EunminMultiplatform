import io.eunmin.multiplatform.convention.configureMultiplatformCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureMultiplatformCompose()
        }
    }
}