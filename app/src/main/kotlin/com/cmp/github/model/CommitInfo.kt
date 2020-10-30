package com.cmp.github.model

import com.google.gson.annotations.SerializedName


data class CommitInfo(
		@SerializedName("url") val url: String,
		@SerializedName("sha") val sha: String,
		@SerializedName("node_id") val node_id: String,
		@SerializedName("html_url") val html_url: String,
		@SerializedName("comments_url") val comments_url: String,
		@SerializedName("commit") val commit: Commit,
		@SerializedName("author") val author: Author,
		@SerializedName("committer") val committer: Committer,
		@SerializedName("parents") val parents: List<Parents>?
): Comparable<CommitInfo>{
	override fun compareTo(other: CommitInfo): Int {
		val otherCommit = other.commit
		return when {
			commit.committer.date == otherCommit.committer.date -> 0
			commit.committer.date < otherCommit.committer.date -> 1
			commit.committer.date > otherCommit.committer.date -> -1
			else -> 0
		}
	}
}