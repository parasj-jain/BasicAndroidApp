package com.paras.baseapplication.base.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface APIEndPoint {

    @GET
    fun fetchData(@Url url: String) : Observable<String>

}