package com.example.testestant.dependency

import com.example.testestant.utils.Constants.API_KEY
import com.example.testestant.utils.Constants.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AppModule {
    inline fun <reified T> createNetworkService(): T{

        //Log
        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY

        //Client
        val client = OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val originalUrl = originalRequest.url
                val newUrl = originalUrl.newBuilder()
                    .addQueryParameter("apiKey", API_KEY)
                    .build()

                val newRequest = originalRequest.newBuilder().url(newUrl).build()

                chain.proceed(
                    newRequest
                        .newBuilder()
                        .addHeader(
                            "Content-Type",
                            "application/json"
                        )
                        .build()
                )
            }
            .addInterceptor(log)
            .build()

        //RetrofitBuilder

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()


        return retrofit.create(T::class.java)
    }
}




