package com.example.foodapp.data.remote

import com.example.foodapp.model.retrofit.FoodList
import com.example.foodapp.model.retrofit.Joke
import com.example.foodapp.utils.RetrofitInstance
import retrofit2.Response
import javax.inject.Inject

class RemoteFoodRepository @Inject constructor(private val service: FoodService) {
    private val apiKey = RetrofitInstance.API_KEY

    suspend fun getFood(): Response<FoodList?> {
        return service.getFood(apiKey, 5)
    }
}