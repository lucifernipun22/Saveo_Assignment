package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@SerializedName("score")
	val score: Double? = null,

	@SerializedName("show")
	val show: Show? = null
)