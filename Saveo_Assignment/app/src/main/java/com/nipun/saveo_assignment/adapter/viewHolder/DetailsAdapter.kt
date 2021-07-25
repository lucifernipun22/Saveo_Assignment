package com.nipun.saveo_assignment.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nipun.saveo_assignment.R
import com.nipun.saveo_assignment.model.db.MyDataEntity

/**
 * This adapter is a basically used for a detail horizontal Recycler view and set in a Main Activity

   created by: Nipun jain
 */
class DetailsAdapter(private var dataList: List<MyDataEntity>, var onClickOfItem: OnClickOfItem) :

        RecyclerView.Adapter<DetailsViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_second, parent, false)
        return DetailsViewHolder(view, onClickOfItem)
        }

        override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val list = dataList[position]
        holder.setData(list)
        }

        override fun getItemCount(): Int {
        return dataList.size
        }

        fun updateList1(modelList: List<MyDataEntity>) {
        dataList = modelList
        notifyDataSetChanged()
        }


}