package com.nipun.saveo_assignment.repository

import androidx.lifecycle.LiveData
import com.nipun.saveo_assignment.model.db.MyDataDao
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.model.network.Network
import com.nipun.saveo_assignment.model.network.ApiClient


class ListRepository(private val myDataDao: MyDataDao) {
    val apiClient = Network.getInstance().create(ApiClient::class.java)
    lateinit var myDataEntity: MyDataEntity

    /**
     * This method is used to insert data in a database
     */
    suspend fun getListOfModel(page: Int) {
        val response = apiClient.getShows(page)
        for (i in response.indices) {
            myDataEntity = MyDataEntity(
                response.get(i).image.original,
                response.get(i).name,
                response.get(i).language,
                response.get(i).type,
                response.get(i).rating.average.toString(),
                response.get(i).summary
            )
            myDataDao.insert(myDataEntity)
        }
    }

    /**
     * This method is used to get the list from livedata
     */
    fun getList(page: Int): LiveData<List<MyDataEntity>> {
        return myDataDao.getTask()
    }
}