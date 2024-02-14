package com.example.worldcinema

import retrofit2.Call
import retrofit2.http.GET

interface harry_interface {
    @GET("characters")
    fun getharry():Call<MutableList<harry_model>>
}