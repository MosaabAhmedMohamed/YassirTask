package com.example.core.util

import com.example.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_TOKEN).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}