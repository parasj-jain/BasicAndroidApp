import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependancies {

    private val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Android Core Libraries
    private val coreKtxLib = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val activityKtxLib = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private val fragmentKtxLib = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    private val appCompatLib = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private val constraintLayoutLib = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val cardViewLib = "androidx.cardview:cardview:${Versions.cardView}"
    private val recyclerViewLib = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    // Hilt
    private val hiltLib = "com.google.dagger:hilt-android:${Versions.hilt}"
    private val hiltKaptLib = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Retrofit
    private val retrofitLib = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val retrofitGsonLib = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val retrofitRxJava2Lib = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJava2}"

    // Gson
    private val gsonLib = "com.google.code.gson:gson:${Versions.gson}"

    // Okhttp Logging
    private val okhttpLoggingLib = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    // Chucker
    private val chuckerLib = "com.github.chuckerteam.chucker:library:${Versions.chucker}"

    // Testing
    private val jUnitLib = "junit:junit:${Versions.jUnit}"

    // Android Testing
    private val jUnitExtLib = "androidx.test.ext:junit:${Versions.jUnitExt}"
    private val espressoLib = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtxLib)
        add(activityKtxLib)
        add(fragmentKtxLib)
        add(appCompatLib)
        add(constraintLayoutLib)
        add(cardViewLib)
        add(recyclerViewLib)
    }

    val networkApiLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(appCompatLib)
        add(hiltLib)
    }

    val networkInternalLibraries = arrayListOf<String>().apply {
        add(retrofitLib)
        add(retrofitGsonLib)
        add(retrofitRxJava2Lib)
        add(gsonLib)
        add(okhttpLoggingLib)
    }

    val networkDebugLibraries = arrayListOf<String>().apply {
        add(chuckerLib)
    }

    val kaptLibraries = arrayListOf<String>().apply {
        add(hiltKaptLib)
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

fun DependencyHandler.api(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
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