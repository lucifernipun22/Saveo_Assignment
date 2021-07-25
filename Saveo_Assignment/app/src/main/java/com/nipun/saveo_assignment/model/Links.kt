package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Links(

	@field:SerializedName("self")
	val self: Self? = null,

	@field:SerializedName("previousepisode")
	val previousepisode: Previousepisode? = null
)