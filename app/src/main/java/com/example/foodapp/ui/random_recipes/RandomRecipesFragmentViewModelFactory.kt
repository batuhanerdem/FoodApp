package com.example.foodapp.ui.random_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.retrofit.RemoteFoodRepository

class RandomRecipesFragmentViewModelFactory(private val repository: RemoteFoodRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomRecipesFragmentViewModel::class.java)) {
            return RandomRecipesFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}