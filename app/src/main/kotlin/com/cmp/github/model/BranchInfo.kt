package com.cmp.github.model

import com.google.gson.annotations.SerializedName

data class BranchInfo(
	@SerializedName("name") val name: String,
	@SerializedName("commit") val commit: Commit,
	@SerializedName("_links") val _links: Links,
	@SerializedName("protected") val protected: Boolean,
	@SerializedName("protection") val protection: Protection,
	@SerializedName("protection_url") val protection_url: String
)