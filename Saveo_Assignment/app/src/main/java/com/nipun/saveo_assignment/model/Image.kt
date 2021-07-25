package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Image(

	@SerializedName("original")
	val original: String? = null,

	@SerializedName("medium")
	val medium: String? = null
)