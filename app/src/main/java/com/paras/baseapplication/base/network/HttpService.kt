package com.paras.baseapplication.base.network

import com.google.gson.GsonBuilder
import com.paras.baseapplication.base.utils.CommonConstants
import com.paras.baseapplication.base.utils.debugLog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpService private constructor() {

    private var apiEndPoint: APIEndPoint? = null
    private var retrofit: Retrofit? = null

    init {
        val loggingInterceptor =
            HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    HttpService::class.java.simpleName.debugLog("OKHTTP ---> $message")
                }
            })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val gson = GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
        okHttpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.addHeader("key", CommonConstants.YOUTUBE_API_KEY)
            requestBuilder.method(original.method, original.body)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        val client = okHttpClient.build()
        retrofit = Retrofit.Builder().baseUrl("https://www.googleapis.com/youtube/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client).build()
        apiEndPoint = retrofit?.create(APIEndPoint::class.java)
    }

    companion object {

        private var INSTANCE: HttpService? = HttpService()

        fun getInstance(): HttpService? {
            if (INSTANCE == null) {
                synchronized(HttpService::class) {
                    if (INSTANCE == null)
                        INSTANCE = HttpService()
                }
            }
            return INSTANCE
        }

    }

}