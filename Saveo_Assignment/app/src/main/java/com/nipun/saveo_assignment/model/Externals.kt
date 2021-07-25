package com.nipun.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class Externals(

	@field:SerializedName("thetvdb")
	val thetvdb: Int? = null,

	@field:SerializedName("imdb")
	val imdb: String? = null,

	@field:SerializedName("tvrage")
	val tvrage: Int? = null
)