package com.example.rickandmortyapi.date.remote

import com.example.rickandmortyapi.date.remote.apiservice.CharacterApiService
import com.example.rickandmortyapi.date.remote.apiservice.LocationApiService
import com.example.rickandmortyapi.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideCharacterApiService() = retrofitClient.create(CharacterApiService::class.java)

    fun provideLocationApiService() = retrofitClient.create(LocationApiService::class.java)
}