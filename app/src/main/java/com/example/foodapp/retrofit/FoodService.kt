package com.example.foodapp.retrofit

import com.example.foodapp.model.Food
import com.example.foodapp.model.retrofit.FoodList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {
    @GET("recipes/random")
    suspend fun getFood(
        @Query("apiKey") apiKey: String?,
        @Query("number") number: Int?
    ): Response<FoodList?>
}