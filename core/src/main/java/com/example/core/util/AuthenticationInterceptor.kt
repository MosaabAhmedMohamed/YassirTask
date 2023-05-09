package com.example.core.util

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("api_key", APIConst.API_KEY).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}