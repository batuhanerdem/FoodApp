package com.example.foodapp.ui.random_recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentRandomRecipesBinding
import com.example.foodapp.model.Food
import com.example.foodapp.ui.adapter.RecipesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomRecipesFragment : Fragment() {
    private lateinit var binding: FragmentRandomRecipesBinding
    private val viewModel: RandomRecipesFragmentViewModel by viewModels()//hilt
    private lateinit var adapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
    }

    private fun setObserver() {
        viewModel.getRandomFoods().observe(viewLifecycleOwner, Observer { foodList ->
            foodList?.body()?.recipes?.let {
                setRV(it)
            }
        })
    }

    private fun setRV(foodList: List<Food>) {
        adapter = RecipesAdapter(foodList) { food, bool ->
            if (bool) {
                viewModel.insertFood(food)
            } else {
                viewModel.deleteFood(food)
            }
        }
        binding.recyclerFood.adapter = adapter
        binding.recyclerFood.layoutManager = LinearLayoutManager(context)
    }
}