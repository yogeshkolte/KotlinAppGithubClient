package com.cmp.github.network

import com.cmp.github.model.CommitInfo
import com.cmp.github.model.Repo


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


const val API_BASE_URL = "https://api.github.com/"

val okHttpClient = OkHttpClient.Builder().build()


private val retrofit = Retrofit.Builder()
    .baseUrl(API_BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface GitHubService {
    @Headers("Accept: application/vnd.github.v3.full+json")
    @GET("user/repos")
    suspend fun getRepos(
        @Header("Authorization") authorization: String,
        @Query("type") type: String = "private"
    ): List<Repo>

    @Headers("Accept: application/vnd.github.v3.full+json")
    @GET("/repos/{owner}/{repo}/commits")
    suspend fun getCommits(
        @Header("Authorization") authorization: String,
        @Path("owner") ownerId: String,
        @Path("repo") repo: String,
        @Query("page") page: String = "1",
        @Query("per_page") perpage: String = "60"
    ): List<CommitInfo>
}

object GitHubApi {
    val gitHubService: GitHubService by lazy {
        retrofit.create(GitHubService::class.java)
    }
}