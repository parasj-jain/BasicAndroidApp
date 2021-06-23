package com.paras.baseapplication.base.di

import android.app.Application
import android.content.Context
import com.paras.baseapplication.base.annotations.ApplicationContext
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelModule::class])
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun providesContext(application: Application): Context

}