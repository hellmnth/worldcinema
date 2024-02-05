package com.example.worldcinema

import retrofit2.Call
import retrofit2.http.GET

interface postget {
    @GET("user")
    fun postget():Call<data_model1>
}