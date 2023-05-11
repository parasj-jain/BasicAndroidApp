package com.paras.baseapplication.network

import com.paras.baseapplication.network.utils.APIConstants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(APIConstants.API_QUERY_PARAM_API_KEY, APIConstants.API_KEY)
            .addQueryParameter(APIConstants.API_QUERY_PARAM_FORMAT, APIConstants.API_FORMAT_JSON)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}