package com.cmp.github.model

import com.google.gson.annotations.SerializedName

data class Protection(
	@SerializedName("enabled") val enabled: Boolean,
	@SerializedName("required_status_checks") val required_status_checks: RequiredStatusChecks
)