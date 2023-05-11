package com.paras.baseapplication.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiEndPointModule {

    @Provides
    @Singleton
    fun provideRecipeApi(
        retrofit: Retrofit
    ): ApiEndPoint {
        return retrofit.create(ApiEndPoint::class.java)
    }

}