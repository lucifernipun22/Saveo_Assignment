package com.nipun.saveo_assignment.model.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(myDataEntity: MyDataEntity)

    @Query("select * from my_data_table")
    fun getTask(): LiveData<List<MyDataEntity>>
}