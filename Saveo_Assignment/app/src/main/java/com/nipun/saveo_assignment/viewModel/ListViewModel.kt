package com.nipun.saveo_assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListViewModel(val respository: ListRepository) : ViewModel() {

    /**
     * This method is used to set the data for ui and passed to the mainActivity
     */
    fun getData(page: Int): LiveData<List<MyDataEntity>> {
        return respository.getList(page)
    }
    /**
     * This is used for callback
     */
    fun insertData(page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            respository.getListOfModel(page)
        }

    }
}