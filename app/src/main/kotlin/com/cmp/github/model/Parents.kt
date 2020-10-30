package com.cmp.github.model

import com.google.gson.annotations.SerializedName

data class Parents(
	@SerializedName("url") val url: String,
	@SerializedName("sha") val sha: String
)