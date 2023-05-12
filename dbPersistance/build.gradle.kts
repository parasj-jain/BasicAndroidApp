plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
}

dependencies {
    implementation(project(":core"))
    implementation(AppDependancies.dbPersistanceInternalLibraries)
    kapt(AppDependancies.dbPersistanceKaptLibraries)
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}