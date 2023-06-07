import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        // Workaround for https://youtrack.jetbrains.com/issue/KT-44884
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.17.3")
    }
}

plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
    alias(libs.plugins.sqlDelight).apply(false)
    alias(libs.plugins.detekt)
}

val detektPluginId: String = libs.plugins.detekt.get().pluginId
val detektFormatting: Provider<MinimalExternalModuleDependency> = libs.detekt.formatting

subprojects {
    apply {
        plugin(detektPluginId)
    }

    // Workaround for https://youtrack.jetbrains.com/issue/KT-44884
    apply(plugin = "kotlinx-atomicfu")

    detekt {
        buildUponDefaultConfig = true
        config = files("../config/detekt.yml")
    }

    dependencies {
        detektPlugins(detektFormatting)
    }

    tasks.withType<Detekt>().configureEach {
        reports {
            html.required.set(true) // observe findings in your browser with structure and code snippets
            xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
            txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
            sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with GitHub Code Scanning
            md.required.set(true) // simple Markdown format
        }
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "1.8"
    }
    tasks.withType<DetektCreateBaselineTask>().configureEach {
        jvmTarget = "1.8"
    }
}