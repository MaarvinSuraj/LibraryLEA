package com.example.apifunctionalities

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("products?noofRecords=10&idStarts=1001&currency=usd")
    suspend fun getProducts(): Response<List<Product>>
}