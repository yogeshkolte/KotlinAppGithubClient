package com.cmp.github.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class CommitPersonDetails(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("date") val date: Date
)