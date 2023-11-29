package com.cocodev2500.movieapp.network

import com.cocodev2500.movieapp.core.Constant
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {
    val webService : WebService by lazy {
       Retrofit.Builder()
           .baseUrl(Constant.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
           .build()
           .create(WebService::class.java)
    }
}