package com.nipun.saveo_assignment.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_table")
data class MyDataEntity(
    @ColumnInfo(name = "image") val image: String){

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = null
}