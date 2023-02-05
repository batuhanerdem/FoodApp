package com.example.foodapp.ui.random_recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.foodapp.model.retrofit.FoodList
import com.example.foodapp.retrofit.RemoteFoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RandomRecipesFragmentViewModel @Inject constructor(private val repository: RemoteFoodRepository) :
    ViewModel() {
    private val randomFoods = liveData {
        val foods = repository.getFood()
        emit(foods)
    }

    fun getRandomFoods(): LiveData<Response<FoodList?>> {
        return randomFoods
    }
}