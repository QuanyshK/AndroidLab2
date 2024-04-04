package com.example.androidlab2.network

import com.example.androidlab2.model.Cat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("cats")
    fun catBy(@Query("name") name: String? = null,   @Query("family_friendly") family_friendly: List<Int>? = null): Call<List<Cat>>

}