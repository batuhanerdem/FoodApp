package com.example.foodapp.data.local

import androidx.room.TypeConverter
import com.example.foodapp.model.retrofit.ExtendedIngredient
import com.example.foodapp.model.retrofit.ProductMatche
import com.example.foodapp.model.retrofit.WinePairing
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun stringToListOfStrings(value: String): List<String> {
        val listType: Type = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listOfStringsToString(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun listOfExtendedIngredientToString(list: List<ExtendedIngredient>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToListOfExtendedIngredient(value: String): List<ExtendedIngredient> {
        val listType: Type = object : TypeToken<List<ExtendedIngredient?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listOfProductMatcheToString(productMatches: List<ProductMatche>?): String {
        val gson = Gson()
        return gson.toJson(productMatches)
    }

    @TypeConverter
    fun stringToListOfProductMatche(value: String): List<ProductMatche>? {
        val listType: Type = object : TypeToken<List<ProductMatche>?>() {}.type
        return Gson().fromJson(value, listType)
    }

//    @TypeConverter
//    fun winePairingToString(value: WinePairing): String {
//        val gson = Gson()
//        return gson.toJson(value)
//    }
//
//    @TypeConverter
//    fun stringToWinePairing(value: String): WinePairing {
//        val objectType: Type = object : TypeToken<WinePairing>() {}.type
//        return Gson().fromJson(value, objectType)
//    }
}