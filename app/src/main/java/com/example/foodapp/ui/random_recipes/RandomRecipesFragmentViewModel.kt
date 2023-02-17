package com.example.foodapp.ui.random_recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.local.LocalFoodRepository
import com.example.foodapp.model.retrofit.FoodList
import com.example.foodapp.data.remote.RemoteFoodRepository
import com.example.foodapp.model.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RandomRecipesFragmentViewModel @Inject constructor(
    private val remoteRepository: RemoteFoodRepository,
    private val localFoodRepository: LocalFoodRepository
) :
    ViewModel() {
    private val randomFoods = liveData {
        val foods = remoteRepository.getFood()
        emit(foods)
    }

    fun getRandomFoods(): LiveData<Response<FoodList?>> {
        return randomFoods
    }

    fun insertFood(food: Food) { //this will add the foods to the favorites later
        viewModelScope.launch {
            localFoodRepository.insertFood(food)
        }
    }

    fun deleteFood(food: Food) {
        viewModelScope.launch {
            localFoodRepository.deleteFood(food)
        }
    }
}