package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class WebChannel(

	@field:SerializedName("country")
	val country: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)