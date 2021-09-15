import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

gradlePlugin {
    plugins {

        // Application Plugin
        register("chop-application-plugin") {
            id = "chop-application-plugin"
            implementationClass = "co.chop.assessment.plugins.ChopApplicationPlugin"
        }

        // Library Plugin
        register("chop-library-plugin") {
            id = "chop-library-plugin"
            implementationClass = "co.chop.assessment.plugins.ChopLibraryPlugin"
        }
    }
}

buildscript {

    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.github.ben-manes:gradle-versions-plugin:0.21.0")
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.5.21"
}

dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.2.2")
    implementation(kotlin("gradle-plugin", "1.5.21"))
    implementation(kotlin("gradle-plugin-api", "1.5.21"))
    implementation(kotlin("android-extensions"))


}