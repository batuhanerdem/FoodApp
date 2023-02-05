package com.example.foodapp.ui.random_recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.databinding.FragmentRandomRecipesBinding
import com.example.foodapp.retrofit.RemoteFoodRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RandomRecipesFragment : Fragment() {
    private lateinit var binding: FragmentRandomRecipesBinding
    private lateinit var viewModel: RandomRecipesFragmentViewModel

    @Inject
    lateinit var remoteFoodRepository: RemoteFoodRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = RandomRecipesFragmentViewModelFactory(remoteFoodRepository)
        viewModel =
            ViewModelProvider(this, factory)[RandomRecipesFragmentViewModel::class.java]
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