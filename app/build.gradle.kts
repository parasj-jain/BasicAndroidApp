plugins {
    id("com.android.application")
    kotlin("android")
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
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(AppDependancies.appLibraries)
    testImplementation(AppDependancies.testLibraries)
    androidTestImplementation(AppDependancies.androidTestLibraries)
}