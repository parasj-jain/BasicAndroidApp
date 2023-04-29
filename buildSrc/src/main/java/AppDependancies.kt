import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependancies {

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // Android Libraries
    val coreKtxLib = "androidx.core:core-ktx:${Versions.coreKtx}"
    val appCompatLib = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayoutLib = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val cardViewLib = "androidx.cardview:cardview:${Versions.cardView}"
    val recyclerViewLib = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    // Retrofit
    val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonLib = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitRxJava2Lib = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJava2}"

    // Gson
    val gsonLib = "com.google.code.gson:gson:${Versions.gson}"

    // Okhttp Logging
    val okhttpLoggingLib = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    // Testing
    val jUnitLib = "junit:junit:${Versions.jUnit}"

    // Android Testing
    val jUnitExtLib = "androidx.test.ext:junit:${Versions.jUnitExt}"
    val espressoLib = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtxLib)
        add(appCompatLib)
        add(constraintLayoutLib)
        add(cardViewLib)
        add(recyclerViewLib)
        add(retrofitLib)
        add(retrofitGsonLib)
        add(retrofitRxJava2Lib)
        add(gsonLib)
        add(okhttpLoggingLib)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(jUnitExtLib)
        add(espressoLib)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(jUnitLib)
    }

}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}