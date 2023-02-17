package com.example.foodapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp.model.Food

@Dao
interface FoodDAO {
    @Insert
    suspend fun insertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Query("DELETE FROM Food WHERE :id = uid")
    suspend fun deleteFoodById(id: Int)

    @Query("DELETE FROM food")
    suspend fun clearDB()

    @Query("SELECT * FROM food")
    suspend fun getAllFoods(): List<Food>

    @Query("SELECT * FROM food WHERE :id = uid")
    suspend fun getFoodById(id: Int) : Food


}