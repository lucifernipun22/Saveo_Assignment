package com.nipun.saveo_assignment.repository

import androidx.lifecycle.LiveData
import com.nipun.saveo_assignment.model.db.MyDataDao
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.nobroker.ApiCall.Network
import com.nipun.saveo_assignment.model.network.ApiClient


class ListRepository(val MyDataDaoObject: MyDataDao) {
    val apiClient=Network.getInstance().create(ApiClient::class.java)
    lateinit var myDataEntity : MyDataEntity

    suspend fun getListOfModel(){
            val resposne=apiClient.getShows("1")
            for(i in resposne.indices){
                myDataEntity = MyDataEntity(resposne.get(i).show?.image?.original.toString())
                MyDataDaoObject.insert(myDataEntity)
            }


    }

    fun getlist(): LiveData<List<MyDataEntity>> {
        return MyDataDaoObject.getTask()
    }
}