package com.example.foodapp.retrofit

import com.example.foodapp.model.retrofit.FoodList
import com.example.foodapp.utils.RetrofitInstance
import retrofit2.Response

class RemoteFoodRepository(private val service: FoodService) {
    private val apiKey = RetrofitInstance.API_KEY
    suspend fun getFood(): Response<FoodList?> {
        return service.getFood(apiKey, 10)
    }
}