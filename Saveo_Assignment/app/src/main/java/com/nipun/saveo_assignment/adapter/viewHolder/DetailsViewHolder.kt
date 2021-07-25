package com.nipun.saveo_assignment.adapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.saveo_assignment.model.db.MyDataEntity
import kotlinx.android.synthetic.main.item_second.view.*
/**
 * This is viewHolder which is used for set the horizontal RecyclerView data and initialize in a DetailsAdapter class

   created by: Nipun jain
 */
class DetailsViewHolder(private val view: View, var onclick: OnClickOfItem) :
    RecyclerView.ViewHolder(view) {

    fun setData(dataModelItem: MyDataEntity) {
        view.apply {
            Glide.with(image_movie).load(dataModelItem.image).into(image_movie)
            image_Cardview.setOnClickListener {
                onclick.showDetails(dataModelItem, adapterPosition)
            }
        }
    }
}