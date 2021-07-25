package com.nipun.saveo_assignment.adapter.viewHolder


import com.nipun.saveo_assignment.model.db.MyDataEntity

interface OnClickOfItem {

    fun showDetails(dataModelItem: MyDataEntity, position:Int)
}