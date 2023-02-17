package com.example.foodapp.ui.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btnFavoriteRecipes.setOnClickListener {
            val menuToFavoriteId = R.id.action_menuFragment_to_favoriteRecipesFragment
            goTo(menuToFavoriteId, it)
        }
        binding.btnRandomRecipes.setOnClickListener {
            val menuToRandomId = R.id.action_menuFragment_to_randomRecipesFragment
            goTo(menuToRandomId, it)
        }
    }

    private fun goTo(actionId: Int, view: View) {
        view.findNavController().navigate(actionId)
    }
}