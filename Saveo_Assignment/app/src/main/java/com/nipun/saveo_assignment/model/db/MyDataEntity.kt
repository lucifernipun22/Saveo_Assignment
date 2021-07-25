package com.nipun.saveo_assignment.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_table")
data class MyDataEntity(
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "movieName") val movieName: String,
    @ColumnInfo(name = "hour") val hour: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "review") val review: String,
    @ColumnInfo(name = "summary") val summary: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}