package com.example.worldcinema

import retrofit2.Call
import retrofit2.http.GET

interface get_interface {
    @GET("marvel")
    fun getposter():Call<MutableList<data_model>>
}