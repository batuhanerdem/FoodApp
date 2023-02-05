package com.example.foodapp.model.retrofit


import com.example.foodapp.model.Food
import com.google.gson.annotations.SerializedName

data class FoodList(
    val recipes: List<Food>
)