package com.example.apifunctionalities

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHandler {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://hub.dummyapis.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi = retrofit.create(ProductApi::class.java)

    suspend fun fetchProducts(): Response<List<Product>> {
        return productApi.getProducts()
    }
}