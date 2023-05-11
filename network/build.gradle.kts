plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdkVersion(AppConfig.compileSdk)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    api(AppDependancies.networkApiLibraries)
    implementation(AppDependancies.networkInternalLibraries)
    debugImplementation(AppDependancies.networkDebugLibraries)
    kapt(AppDependancies.kaptLibraries)
    testImplementation(AppDependancies.testLibraries)
    androidTestImplementation(AppDependancies.androidTestLibraries)
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}