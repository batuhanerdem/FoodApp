package com.example.foodapp.data.local

import com.example.foodapp.model.Food

class LocalFoodRepository(private val dao: FoodDAO) {
    suspend fun getAllFoods(): List<Food> {
        return dao.getAllFoods()
    }

    suspend fun insertFood(food: Food) {
        dao.insertFood(food)
    }

    suspend fun deleteFood(food: Food) {
        dao.deleteFood(food)
    }

    suspend fun deleteFoodById(id: Int) {
        dao.deleteFoodById(id)
    }

    suspend fun clearDB() {
        dao.clearDB()
    }
    suspend fun getFoodById(id:Int){
        dao.getFoodById(id)
    }


}