package com.example.foodapp.data.remote

import com.example.foodapp.model.retrofit.FoodList
import com.example.foodapp.model.retrofit.Joke
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