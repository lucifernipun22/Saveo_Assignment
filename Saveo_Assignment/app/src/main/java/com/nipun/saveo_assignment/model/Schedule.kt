package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Schedule(

	@field:SerializedName("days")
	val days: List<String?>? = null,

	@field:SerializedName("time")
	val time: String? = null
)