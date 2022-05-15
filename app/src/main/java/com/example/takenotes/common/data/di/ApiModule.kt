package com.example.takenotes.common.data.di

import com.example.takenotes.common.data.api.model.ApiConstants
import com.example.takenotes.common.data.api.model.JsonPlaceholderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideJsonPlaceholderApi(builder: Retrofit.Builder): JsonPlaceholderApi {
        return builder
            .build()
            .create(JsonPlaceholderApi::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}