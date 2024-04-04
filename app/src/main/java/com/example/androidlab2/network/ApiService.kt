package com.example.androidlab2.network

import com.example.androidlab2.model.Cat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("cats?family_friendly=5")
    fun fetchCats(): Call<List<Cat>>
    fun catByName(@Query("name") name: String): Call<List<Cat>>

}