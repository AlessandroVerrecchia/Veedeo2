package com.example.pexels.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PexelsApiClient {
    val BASE_URL: String = "https://api.pexels.com/videos/"
    val AUTH_KEY: String = "JXRi84qIVBXDLy4g6EkgI6XMTxGyYQ8z4CwtDPGnSgyfroHF5k3wJRCC"


    fun build(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", AUTH_KEY)
                .build()
            chain.proceed(newRequest)
        }.build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}