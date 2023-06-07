plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.cocoapods)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
    id("com.android.library")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Compose application framework"
        homepage = "empty"
        ios.deploymentTarget = "11.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "Common"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Napier
                implementation(libs.napier)

                // KotlinX
                with(libs.kotlinx) {
                    // Coroutines
                    implementation(coroutines.core)
                    // Serialization
                    implementation(serialization.json)
                    // DateTime
                    implementation(datetime)
                }

                // Ktor
                implementation(libs.ktor.core)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.client.auth)
                implementation(libs.logback.classic)

                // Multiplatform Settings
                implementation(libs.multiplatformSettings)
                implementation(libs.multiplatformSettings.no.arg)

                // Koin
                implementation(libs.koin.core)

            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                // Ktor
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.client.android)

                // SQLDelight
                implementation(libs.sqlDelight.driver.android)

            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                // Ktor
                implementation(libs.ktor.client.darwin)

                // SQLDelight
                implementation(libs.sqlDelight.driver.native)

            }
        }

        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.lissene_kids.app.common"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


buildConfig {
  // BuildConfig configuration here.
  // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
}

sqldelight {
  databases {
    create("IMDatabase") {
      // Database configuration here.
      // https://cashapp.github.io/sqldelight
      packageName.set("com.lissene_kids.app.db")
    }
  }
}
