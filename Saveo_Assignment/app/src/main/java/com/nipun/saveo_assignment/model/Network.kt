package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Network(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)