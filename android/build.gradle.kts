plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.lissene_kids.app.android"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()

        applicationId = "com.lissene_kids.app.android"
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
        implementation("androidx.activity:activity-compose:1.7.2")

        // ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

        //Coil
        implementation(libs.coil.compose)
        implementation("androidx.compose.ui:ui-util:1.4.3")

        // ConstraintLayout
        implementation(libs.androidx.constraintLayout)


        // Accompanist Permissions
        implementation("com.google.accompanist:accompanist-permissions:0.31.2-alpha")



        implementation(libs.koin.core)
        implementation("androidx.navigation:navigation-compose:2.5.3")

        implementation ("io.insert-koin:koin-androidx-compose:3.4.0")
    }
}