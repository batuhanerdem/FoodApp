package com.example.foodapp.di

import android.content.Context
import android.content.ContextWrapper
import com.example.foodapp.data.local.FoodDAO
import com.example.foodapp.data.local.FoodDatabase
import com.example.foodapp.data.local.LocalFoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): FoodDatabase {
        return FoodDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providesDao(database: FoodDatabase): FoodDAO {
        return database.foodDao
    }

    @Singleton
    @Provides
    fun provideRepository(dao: FoodDAO): LocalFoodRepository {
        return LocalFoodRepository(dao)
    }
}