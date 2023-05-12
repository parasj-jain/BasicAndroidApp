package com.paras.baseapplication.dbPersistance.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data(
    @PrimaryKey @ColumnInfo("id") val id: String = "0",
    @ColumnInfo("name") val name: String? = null
)