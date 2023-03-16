package com.example.retrofitmvvmwithrecyclerview

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProductsList(): Call<Model>
}