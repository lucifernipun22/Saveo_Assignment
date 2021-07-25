package com.nipun.saveo_assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.saveo_assignment.R
import com.nipun.saveo_assignment.adapter.viewHolder.ListViewHolder
import com.nipun.saveo_assignment.adapter.viewHolder.OnClickOfItem
import com.nipun.saveo_assignment.model.db.MyDataEntity

/**
 * This adapter is a basically used for a Grid Recycler view and set in a Main Activity

   created by: Nipun jain
 */
class ListAdapter(private var dataList: List<MyDataEntity>, var onClickOfItem: OnClickOfItem) :
    RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ListViewHolder(view, onClickOfItem)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = dataList[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(modelList: List<MyDataEntity>) {
        dataList = modelList
        notifyDataSetChanged()
    }
    }