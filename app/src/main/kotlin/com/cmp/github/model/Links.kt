package com.cmp.github.model

import com.google.gson.annotations.SerializedName

data class Links(
	@SerializedName("html") val html: String,
	@SerializedName("self") val self: String
)