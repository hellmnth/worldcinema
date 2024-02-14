package com.example.worldcinema

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class harryobject {
    fun getHarryObject(): Retrofit = Retrofit.Builder()
        .baseUrl("https://harry-potter-api-en.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}