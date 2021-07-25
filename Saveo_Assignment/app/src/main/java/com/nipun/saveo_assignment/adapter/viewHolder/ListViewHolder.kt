package com.nipun.saveo_assignment.adapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.saveo_assignment.model.db.MyDataEntity
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * This is viewHolder class which is used for set the Grid RecyclerView data and initialize in a ListAdapter class

   created by: Nipun jain
 */
class ListViewHolder(private val view: View, var onclick: OnClickOfItem) :
    RecyclerView.ViewHolder(view) {

    fun setData(dataModelItem: MyDataEntity) {
        view.apply {
            Glide.with(ivAvatar).load(dataModelItem.image).into(ivAvatar)
            itemCard.setOnClickListener {
                onclick.showDetails(dataModelItem, adapterPosition)
            }
        }
    }
}