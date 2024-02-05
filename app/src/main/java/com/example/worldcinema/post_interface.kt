package com.example.worldcinema

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface post_interface {
    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String, String>):Call<data_model1>
    fun getAuth1():Call<data_model1>
}