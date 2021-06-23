package com.paras.baseapplication.base.utils

import android.content.res.Resources
import android.util.Log
import com.paras.baseapplication.BuildConfig

//region Integer Extensions

val Int.dp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

//endregion

// region String Extensions

fun String.debugLog(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(this, message)
    }
}

// endregion