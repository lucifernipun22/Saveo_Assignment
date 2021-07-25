package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Response(

	@SerializedName("Response")
	val response: List<ResponseItem?>? = null
)