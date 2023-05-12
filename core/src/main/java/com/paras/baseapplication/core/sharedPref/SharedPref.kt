package com.paras.baseapplication.core.sharedPref

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPref @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun putString(
        key: String,
        value: String
    ) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putInt(
        key: String,
        value: Int
    ) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun putBoolean(
        key: String,
        value: Boolean
    ) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun putLong(
        key: String,
        value: Long
    ) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun putFloat(
        key: String,
        value: Float
    ) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getString(
        key: String,
        defValue: String? = null
    ) : String? {
        return sharedPreferences.getString(key, defValue)
    }

    fun getInt(
        key: String,
        defValue: Int = 0
    ) : Int {
        return sharedPreferences.getInt(key, defValue)
    }

    fun getBoolean(
        key: String,
        defValue: Boolean
    ) : Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    fun getLong(
        key: String,
        defValue: Long
    ) : Long {
        return sharedPreferences.getLong(key, defValue)
    }

    fun getFloat(
        key: String,
        defValue: Float
    ) : Float {
        return sharedPreferences.getFloat(key, defValue)
    }

    companion object {
        const val FILE_NAME = "shared_pref"
    }

}