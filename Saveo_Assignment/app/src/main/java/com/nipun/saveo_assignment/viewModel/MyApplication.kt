package com.nipun.saveo_assignment.viewModel

import android.app.Application
import com.nipun.saveo_assignment.model.db.MyDataDatabase
import com.nipun.saveo_assignment.repository.ListRepository


class MyApplication:Application() {
    val MyDataDao by lazy {
        val roomDatabase= MyDataDatabase.getDatabase(this)
        roomDatabase.getMyAgeDao()
    }
    val repository by lazy {
        ListRepository(MyDataDao)
    }
}