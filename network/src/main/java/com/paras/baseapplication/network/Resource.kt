package com.paras.baseapplication.network

sealed class Resource<T>(var isLoading: Boolean = false, data: T? = null, error: String? = null) {

    class Success<T>(val data: T) : Resource<T>(false, data)
    class Error<T>(private val error: String?) : Resource<T>(false, null, error)
    class Loading<T> : Resource<T>(true)

}