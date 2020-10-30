package com.cmp.github.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor(

) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().signedRequest()
        return chain.proceed(newRequest)
    }

    private fun Request.signedRequest(): Request {
        val accessToken = ""
        return newBuilder()
            .header("Authorization", "Bearer ${accessToken}")
            .build()
    }
}