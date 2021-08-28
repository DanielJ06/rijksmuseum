package com.example.data_remote.utils

import com.example.data_remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url
            .newBuilder()
            .addQueryParameter("key", BuildConfig.API_KEY)
            .build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

}