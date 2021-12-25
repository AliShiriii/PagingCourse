package com.example.pagingcourse.api

import com.example.pagingcourse.model.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<ResponseApi>


}