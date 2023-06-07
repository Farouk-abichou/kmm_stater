plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.cocoapods)
//    alias(libs.plugins.buildConfig)
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
            baseName = "CommonUI"
            isStatic = true
        }
//        extraSpecAttributes["resources"] = "['src/commonMain/resources/**']"
    }

    sourceSets {
//        all {
//            languageSettings {
//                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
//            }
//        }

        val commonMain by getting {
            dependencies {
                // Compose
                with(compose) {
                    implementation(runtime)
                    implementation(foundation)
                    implementation(material)
                    implementation(material3)
//                    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
//                    implementation(components.resources)
                }

                // Napier
//                implementation(libs.napier)

                // KotlinX
//                with(libs.kotlinx) {
                    // Coroutines
//                    implementation(coroutines.core)
                    // Serialization
//                    implementation(serialization.json)
                    // DateTime
//                    implementation(datetime)
//                }

                // Multiplatform Settings
//                implementation(libs.multiplatformSettings)

                // Koin
//                implementation(libs.koin.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
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
    namespace = "com.lissene_kids.app.common.ui"
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


//buildConfig {
  // BuildConfig configuration here.
  // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
//}