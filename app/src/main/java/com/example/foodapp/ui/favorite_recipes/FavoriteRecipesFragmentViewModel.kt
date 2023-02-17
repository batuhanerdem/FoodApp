package com.example.foodapp.ui.favorite_recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.local.FoodDAO
import com.example.foodapp.data.local.LocalFoodRepository
import com.example.foodapp.model.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteRecipesFragmentViewModel @Inject constructor(
    private val localFoodRepository:
    LocalFoodRepository
) : ViewModel() {
    private var _foods = liveData<List<Food>> {
        val value = localFoodRepository.getAllFoods()
        emit(value)
    }
    var foods: LiveData<List<Food>> = _foods


    fun insertFood(food: Food) {
        viewModelScope.launch {
            localFoodRepository.insertFood(food)
        }
    }

    fun deleteFood(food: Food) {
        viewModelScope.launch {
            localFoodRepository.deleteFood(food)
        }
    }

    fun clearDB() {
        viewModelScope.launch {
            localFoodRepository.clearDB()
        }
    }

}