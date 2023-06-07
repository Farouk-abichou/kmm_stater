plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.kmm_stater.app.android"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()

        applicationId = "com.kmm_stater.app.android"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    dependencies {
        implementation(project(":common"))
        implementation(project(":common-ui"))

        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.activityCompose)
        implementation(libs.compose.material)
        implementation(libs.compose.material3)
        implementation(libs.compose.uitooling)
        implementation(libs.kotlinx.coroutines.android)
        implementation(libs.compose.lifecycle)
        implementation(libs.compose.util)
        implementation(libs.compose.navigation)
        implementation(libs.compose.navigation)

        // Koin
        implementation(libs.koin.core)
        implementation(libs.koin.androidx.compose)

        //Coil
        implementation(libs.coil.compose)

        // ConstraintLayout
        implementation(libs.androidx.constraintLayout)

        // Accompanist Permissions
        implementation(libs.accompanist.permissions)

    }
}