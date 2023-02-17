package com.example.foodapp.ui.adapter

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.FoodRecyclerItemBinding
import com.example.foodapp.model.Food
import com.example.foodapp.model.ImageButtonType

class RecipesAdapter(
    private val foodList: List<Food>,
    isFavorite: Boolean = false,
    private val myCallBack: (food: Food, add: Boolean) -> Unit
) :
    RecyclerView.Adapter<RecipesAdapter.VHMainList>() {
    class VHMainList(val binding: FoodRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var buttonType =
        if (isFavorite) ImageButtonType.SELECTED else ImageButtonType.UNSELECTED
    private var colorList = mutableListOf<Int>()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHMainList {
        val binding =
            FoodRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        setList(parent.context)
        return VHMainList(binding)
    }

    override fun onBindViewHolder(holder: VHMainList, position: Int) {
        val currentFood = foodList[position]
        val imageUri = currentFood.image?.toUri()
        val summary = Html.fromHtml(currentFood.summary)
        val cardBackgroundColor = colorList[randomColorGenerator()]
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(imageUri).into(ivFood)
            tvTitle.text = currentFood.title
            tvFoodText.text = summary
            imgbtnStar.setBackgroundResource(buttonType.resId)
            cardView.setCardBackgroundColor(cardBackgroundColor)
            progressBar.visibility = View.GONE
        }


        holder.binding.imgbtnStar.setOnClickListener {
            buttonType = buttonType.changeType()
            it.setBackgroundResource(buttonType.resId)
            myCallBack.invoke(currentFood, buttonType == ImageButtonType.SELECTED)

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    private fun randomColorGenerator(): Int {
        val seed = System.currentTimeMillis().toInt()
        return kotlin.random.Random(seed).nextInt(colorList.size)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setList(context: Context) {
        colorList.add(context.getColor(R.color.card1))
        colorList.add(context.getColor(R.color.card2))
        colorList.add(context.getColor(R.color.card3))
        colorList.add(context.getColor(R.color.card4))
        colorList.add(context.getColor(R.color.card5))
        colorList.add(context.getColor(R.color.card6))
        colorList.add(context.getColor(R.color.card7))
        colorList.add(context.getColor(R.color.card8))
        colorList.add(context.getColor(R.color.card9))
        colorList.add(context.getColor(R.color.card10))
    }
}