package com.example.foodapp.model.retrofit

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.foodapp.data.local.Converters
import com.google.gson.annotations.SerializedName

@TypeConverters(Converters::class)
data class WinePairing(
    @SerializedName("pairedWines")
    val pairedWines: List<String>?,
    @SerializedName("pairingText")
    val pairingText: String?,
    @SerializedName("productMatches")
    val productMatches: List<ProductMatche>?
)