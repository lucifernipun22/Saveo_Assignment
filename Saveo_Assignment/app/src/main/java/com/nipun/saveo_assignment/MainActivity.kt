package com.nipun.saveo_assignment

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nipun.saveo_assignment.adapter.ListAdapter
import com.nipun.saveo_assignment.adapter.viewHolder.OnClickOfItem
import com.nipun.saveo_assignment.model.ResponseItem
import com.nipun.saveo_assignment.model.db.MyDataDatabase
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.repository.ListRepository
import com.nipun.saveo_assignment.viewModel.ListViewModel
import com.nipun.saveo_assignment.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), OnClickOfItem {

    private lateinit var listViewModel: ListViewModel
    private lateinit var listAdapter: ListAdapter
    val dataModelList = mutableListOf<MyDataEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MyDataDao by lazy {
            val roomDatabase = MyDataDatabase.getDatabase(this)
            roomDatabase.getMyAgeDao()
        }
        val repository by lazy {
            ListRepository(MyDataDao)
        }

        val factory = ViewModelFactory(repository)
        listViewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)
        setRecyclerAdapter()


        if (isNetworkConnected()) {
            CoroutineScope(Dispatchers.IO).launch {
                listViewModel.insertData()
            }

            observeLiveData()
        }
        else if (!isNetworkConnected()) {
            observeLiveData()
        }

    }

    private fun observeLiveData() {

        listViewModel.getData().observe(this, Observer {
            dataModelList.clear()
            dataModelList.addAll(it)
            listAdapter.updateList(dataModelList)
        })
    }


    private fun setRecyclerAdapter() {
        listAdapter = ListAdapter(dataModelList,this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = listAdapter
        }

    }

    override fun showDetails(dataModelItem: MyDataEntity, position: Int) {
        var intent= Intent(this,showDetailActivity::class.java)
        intent.putExtra("image",dataModelItem.image)
        startActivity(intent)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isNetworkConnected(): Boolean {

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }

        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}