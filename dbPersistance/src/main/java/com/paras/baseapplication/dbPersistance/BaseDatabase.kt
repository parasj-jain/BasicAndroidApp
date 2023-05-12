package com.paras.baseapplication.dbPersistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paras.baseapplication.dbPersistance.daos.DataDao
import com.paras.baseapplication.dbPersistance.entities.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class BaseDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {
        const val DATABASE_NAME = "base_application.db"
    }
}