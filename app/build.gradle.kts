plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
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

    packagingOptions {
        exclude("META-INF/kotlin-stdlib-jdk7.kotlin_module")
        exclude("META-INF/kotlin-stdlib-jdk8.kotlin_module")
        exclude("META-INF/com.android.tools/proguard/coroutines.pro")
    }
}

dependencies {

    implementation(AppDependancies.appLibraries)
    kapt(AppDependancies.kaptLibraries)
    testImplementation(AppDependancies.testLibraries)
    androidTestImplementation(AppDependancies.androidTestLibraries)
}