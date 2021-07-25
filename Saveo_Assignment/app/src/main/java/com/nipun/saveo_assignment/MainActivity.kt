package com.nipun.saveo_assignment

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nipun.saveo_assignment.adapter.ListAdapter
import com.nipun.saveo_assignment.adapter.viewHolder.DetailsAdapter
import com.nipun.saveo_assignment.adapter.viewHolder.OnClickOfItem
import com.nipun.saveo_assignment.model.db.MyDataDatabase
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.repository.ListRepository
import com.nipun.saveo_assignment.utils.PaginationScrollListener
import com.nipun.saveo_assignment.viewModel.ListViewModel
import com.nipun.saveo_assignment.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), OnClickOfItem {

    private lateinit var listViewModel: ListViewModel
    private lateinit var listAdapter: ListAdapter
    private lateinit var detailsAdapter: DetailsAdapter
    private var START: Int = 1
    private var TOTAL_PAGE: Int = 5
    private var currentpage = START
    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
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
        setRecyclerAdapter2()

        if (isNetworkConnected()) {
            CoroutineScope(Dispatchers.IO).launch {
                listViewModel.insertData(currentpage)
            }
            observeLiveData()
        } else if (!isNetworkConnected()) {
            observeLiveData()
        }

    }

    /**
     * This is observe Data from Adapter
     */
    private fun observeLiveData() {
        listViewModel.getData(currentpage).observe(this, Observer {
            dataModelList.clear()
            dataModelList.addAll(it)
            listAdapter.updateList(dataModelList)
            detailsAdapter.updateList1(dataModelList)
        })
    }

    /**
     * This is used to setHorizontal RecyclerView
     */
    private fun setRecyclerAdapter2() {
        detailsAdapter = DetailsAdapter(dataModelList, this)
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = detailsAdapter
        }
    }

    /**
     * This is use to setInfiniteScroll View (Recycler View)
     */
    private fun setRecyclerAdapter() {
        listAdapter = ListAdapter(dataModelList, this)
        var layoutManager = GridLayoutManager(this, 3)
        recyclerView1.apply {
            this.layoutManager = layoutManager
            adapter = listAdapter
        }
        loadFirstPage()
        recyclerView1.addOnScrollListener(object :
            PaginationScrollListener(recyclerView1.layoutManager as GridLayoutManager) {
            override fun loadMoreItems() {
                isLoading = true
                currentpage += 1
                Handler(Looper.myLooper()!!).postDelayed({ loadNextPage()
                },1000)
            }
            override fun getTotalPageCount(): Int {
                return TOTAL_PAGE
            }
            override fun isLastPage(): Boolean {
                return isLastPage
            }
            })
    }

    private fun loadNextPage() {
        if (isNetworkConnected()) { listViewModel.getData(currentpage)
        } else { Log.d("Tag","nipun")
        }
    }

    private fun loadFirstPage() {
        if (isNetworkConnected()) { listViewModel.getData(currentpage)
        } else { Log.d("Tag","nipun")
        }
    }

    /**
     * This is used to setItemClickListener on a particular and pass the image to the movieDetailActivity
     */
    override fun showDetails(dataModelItem: MyDataEntity, position: Int) {
        var intent = Intent(this, ShowDetailActivity::class.java)
        intent.putExtra("name", dataModelItem.movieName)
        intent.putExtra("hour", dataModelItem.hour)
        intent.putExtra("date", dataModelItem.date)
        intent.putExtra("review", dataModelItem.review)
        intent.putExtra("summary", dataModelItem.summary)
        intent.putExtra("image", dataModelItem.image)
        startActivity(intent)
    }

    /**
     * This is used to check the connectivity
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { connectivityManager.activeNetwork
        } else { TODO("VERSION.SDK_INT < M")
        }
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}