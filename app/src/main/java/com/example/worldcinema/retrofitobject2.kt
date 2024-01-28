package com.example.worldcinema

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitobject2{
    fun getRetrofitObject2():Retrofit=Retrofit.Builder()
        .baseUrl("http://mskko2021.mad.hakta.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}