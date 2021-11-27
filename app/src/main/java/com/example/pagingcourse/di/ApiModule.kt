package com.example.pagingcourse.di

import com.example.pagingcourse.api.ApiService
import com.example.pagingcourse.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {


    @Provides
    fun provideBaseUri() = Constants.BASE_URL

    @Provides
    fun provideRetrofit(BASE_URL: String): ApiService =

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

//    @Provides
//    @Singleton
//    suspend fun providesApi(retrofit: Retrofit): ApiService =
//
//        retrofit.create(ApiService::class.java)


}