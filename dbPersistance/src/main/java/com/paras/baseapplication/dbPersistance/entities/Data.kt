package com.paras.baseapplication.dbPersistance.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data(
    @PrimaryKey var id: String = "0",
    var name: String? = null
)