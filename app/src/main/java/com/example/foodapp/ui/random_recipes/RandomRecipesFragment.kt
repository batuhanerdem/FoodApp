package com.example.foodapp.ui.random_recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.foodapp.databinding.FragmentRandomRecipesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomRecipesFragment : Fragment() {
    private lateinit var binding: FragmentRandomRecipesBinding

    private val viewModel: RandomRecipesFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRandomFoods().observe(viewLifecycleOwner, Observer {
            if (it.isSuccessful) {
                Log.d(
                    "mytag",
                    "${it.body()?.recipes?.get(1)?.title}    ${it.body()?.recipes?.random()?.id}   "
                )
            }
        })
    }
}