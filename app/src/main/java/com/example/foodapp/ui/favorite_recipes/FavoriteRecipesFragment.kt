package com.example.foodapp.ui.favorite_recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.FragmentFavoriteRecipesBinding
import com.example.foodapp.model.Food
import com.example.foodapp.ui.adapter.RecipesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteRecipesFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteRecipesBinding
    private val viewModel: FavoriteRecipesFragmentViewModel by viewModels()
    private lateinit var adapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
    }

    private fun setObserver() {
        viewModel.foods.observe(viewLifecycleOwner, Observer {
            setRV(it)
        })
    }

    private fun setRV(foodList: List<Food>) {
        adapter = RecipesAdapter(foodList, true) { food, add ->
            if (add) {
                viewModel.insertFood(food)
            } else {
                viewModel.deleteFood(food)
            }
        }
            binding.recyclerFavorites.adapter = adapter
            binding.recyclerFavorites.layoutManager = LinearLayoutManager(context)
        }
    }
