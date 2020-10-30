package com.cmp.github.model

import com.google.gson.annotations.SerializedName

data class RequiredStatusChecks(
	@SerializedName("enforcement_level") val enforcement_level: String,
	@SerializedName("contexts") val contexts: List<String>
)