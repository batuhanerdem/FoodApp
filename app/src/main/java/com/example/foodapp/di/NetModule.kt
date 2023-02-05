package com.example.foodapp.di

import com.example.foodapp.retrofit.FoodService
import com.example.foodapp.retrofit.RemoteFoodRepository
import com.example.foodapp.utils.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(FragmentComponent::class,)
class NetModule() {
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        val baseUrl = RetrofitInstance.BASE_URL
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Provides
    fun provideFoodService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

    @Provides
    fun provideRemoteFoodRepository(service: FoodService): RemoteFoodRepository {
        return RemoteFoodRepository(service)
    }
}