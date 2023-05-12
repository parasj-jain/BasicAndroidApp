package com.paras.baseapplication.dbPersistance.daos

import androidx.room.Dao
import androidx.room.Query
import com.paras.baseapplication.dbPersistance.entities.Data

@Dao
interface DataDao {

    @Query("SELECT * FROM data")
    suspend fun getAllData() : List<Data>

}