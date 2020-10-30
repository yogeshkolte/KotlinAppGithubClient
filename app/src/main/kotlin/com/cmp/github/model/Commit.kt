package com.cmp.github.model
import com.google.gson.annotations.SerializedName

data class Commit(
	@SerializedName("id") val id : String,
	@SerializedName("tree_id") val tree_id : String,
	@SerializedName("message") val message : String,
	@SerializedName("timestamp") val timestamp : String,
	@SerializedName("author") val author : CommitPersonDetails,
	@SerializedName("committer") val committer : CommitPersonDetails
)