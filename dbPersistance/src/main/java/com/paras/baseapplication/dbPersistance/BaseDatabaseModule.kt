package com.paras.baseapplication.dbPersistance

import android.content.Context
import androidx.room.Room
import com.paras.baseapplication.dbPersistance.daos.DataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class BaseDatabaseModule {

    @Singleton
    @Provides
    fun provideBaseDb(@ApplicationContext context: Context): BaseDatabase {
        return Room.databaseBuilder(
            context,
            BaseDatabase::class.java, BaseDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideDataDao(baseDatabase: BaseDatabase): DataDao {
        return baseDatabase.dataDao()
    }

}