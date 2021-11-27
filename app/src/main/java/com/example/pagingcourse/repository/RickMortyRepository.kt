package com.example.pagingcourse.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.pagingcourse.api.ApiService
import com.example.pagingcourse.paging.RickMortyPagingSource
import javax.inject.Inject

class RickMortyRepository @Inject constructor(private val apiService: ApiService){

    fun getRick() = Pager(
        config = PagingConfig(pageSize = 1)){

         RickMortyPagingSource(apiService)

    }.flow

}