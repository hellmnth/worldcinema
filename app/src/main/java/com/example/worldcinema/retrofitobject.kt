package com.example.worldcinema

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitobject {
    fun getRetrofitObject():Retrofit=Retrofit.Builder()
        .baseUrl("https://www.simplifiedcoding.net/demos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}