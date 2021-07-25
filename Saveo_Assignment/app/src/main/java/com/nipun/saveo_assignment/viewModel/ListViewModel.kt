package com.nipun.saveo_assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListViewModel(val respository: ListRepository) : ViewModel() {

    fun getData(): LiveData<List<MyDataEntity>> {
        return respository.getlist()
    }

    fun insertData() {
        CoroutineScope(Dispatchers.IO).launch {
            respository.getListOfModel()
        }

    }
}