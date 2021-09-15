package co.chop.assessment.plugins

import co.chop.assessment.config.blocks.setupAndroidBlock
import co.chop.assessment.config.blocks.setupBuildTypesBlock
import co.chop.assessment.config.blocks.setupFlavorBlock
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

class ChopLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) =
        with(project) {
            applyPlugins()
            androidConfig()
        }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("com.android.library")
            apply("kotlin-android")
            apply("kotlin-kapt")
            apply("com.github.ben-manes.versions")
            apply("androidx.navigation.safeargs")
        }
    }

    private fun Project.androidConfig() {

        setupAndroidBlock(isApplication = false)
        setupBuildTypesBlock(isApplication = false)
        setupFlavorBlock(isApplication = false)

        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
}