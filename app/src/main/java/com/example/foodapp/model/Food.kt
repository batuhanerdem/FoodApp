package com.example.foodapp.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.foodapp.data.local.Converters
import com.example.foodapp.model.retrofit.ExtendedIngredient
import com.example.foodapp.model.retrofit.WinePairing
import com.google.gson.annotations.SerializedName

@Entity
@TypeConverters(Converters::class)
data class Food(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int?,
    @SerializedName("cheap")
    val cheap: Boolean?,
    @SerializedName("creditsText")
    val creditsText: String?,
    @SerializedName("dairyFree")
    val dairyFree: Boolean?,
    @SerializedName("dishTypes")
    val dishTypes: List<String>?,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>?,
    @SerializedName("gaps")
    val gaps: String?,
    @SerializedName("glutenFree")
    val glutenFree: Boolean?,
    @SerializedName("healthScore")
    val healthScore: Double?,
    @PrimaryKey
    @SerializedName("id")
    val uid: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageType")
    val imageType: String?,
    @SerializedName("instructions")
    val instructions: String?,
    @SerializedName("ketogenic")
    val ketogenic: Boolean?,
    @SerializedName("license")
    val license: String?,
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean?,
    @SerializedName("pricePerServing")
    val pricePerServing: Double?,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int?,
    @SerializedName("servings")
    val servings: Int?,
    @SerializedName("sourceName")
    val sourceName: String?,
    @SerializedName("sourceUrl")
    val sourceUrl: String?,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double?,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("sustainable")
    val sustainable: Boolean?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vegan")
    val vegan: Boolean?,
    @SerializedName("vegetarian")
    val vegetarian: Boolean?,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean?,
    @SerializedName("veryPopular")
    val veryPopular: Boolean?,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int?,
    @SerializedName("whole30")
    val whole30: Boolean?,
    @SerializedName("winePairing")
    @Embedded
    val winePairing: WinePairing?
)