package com.paras.baseapplication.core.sharedPref

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SharedPrefModule {

    @Singleton
    @Provides
    fun provideSharedPref(
        sharedPreferences: SharedPreferences
    ) : SharedPref {
        return SharedPref(sharedPreferences)
    }

    @Singleton
    @Provides
    fun provideSharedPreference(
        @ApplicationContext context: Context
    ) : SharedPreferences {
        return context.getSharedPreferences(SharedPref.FILE_NAME, Context.MODE_PRIVATE)
    }

}