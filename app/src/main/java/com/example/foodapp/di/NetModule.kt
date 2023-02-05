package com.example.foodapp.di

import com.example.foodapp.retrofit.FoodService
import com.example.foodapp.retrofit.RemoteFoodRepository
import com.example.foodapp.utils.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule() {
    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        val baseUrl = RetrofitInstance.BASE_URL
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Singleton
    @Provides
    fun provideFoodService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteFoodRepository(service: FoodService): RemoteFoodRepository {
        return RemoteFoodRepository(service)
    }
}