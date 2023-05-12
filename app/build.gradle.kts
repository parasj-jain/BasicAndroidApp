plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)

    defaultConfig {
        applicationId = "com.paras.baseapplication"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

//    signingConfigs {
//        getByName("configRelease") {
//            keyAlias = "${keys.storeAlias}"
//            keyPassword = "${keys.storeKeyPassword}"
//            storeFile = file('keystore/my-release-key.keystore')
//            storePassword = "${keys.storeKeyPassword}"
//        }
//
//        getByName("configDebug") {
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//            storeFile = file('keystore/my.debug.keystore')
//            storePassword = "android"
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }

    packagingOptions {
        exclude("META-INF/kotlin-stdlib-jdk7.kotlin_module")
        exclude("META-INF/kotlin-stdlib-jdk8.kotlin_module")
        exclude("META-INF/com.android.tools/proguard/coroutines.pro")
    }
}

dependencies {

    implementation(AppDependancies.appLibraries)
    implementation(project(":core"))
    implementation(project(":network"))
    implementation(project(":dbPersistance"))
}