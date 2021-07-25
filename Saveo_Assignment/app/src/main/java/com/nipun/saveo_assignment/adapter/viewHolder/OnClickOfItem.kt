package com.nipun.saveo_assignment.adapter.viewHolder

import com.nipun.saveo_assignment.model.db.MyDataEntity

/**
 * This interface is used when the user click on the particular view and go to movie Detail activity

   created by: Nipun jain
 */
interface OnClickOfItem {

    fun showDetails(dataModelItem: MyDataEntity, position:Int)
}