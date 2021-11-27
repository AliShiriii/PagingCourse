package com.example.pagingcourse.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingcourse.api.ApiService
import com.example.pagingcourse.models.RickMorty
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickMortyPagingSource @Inject constructor(private val apiService: ApiService) : PagingSource<Int, RickMorty>(){
    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {

        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMorty> {

        return try {

            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val rickMorty = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<RickMorty>()
            responseData.addAll(rickMorty)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (responseData.isEmpty()) null else currentPage + 1
            )

        }catch (exception : IOException){

            LoadResult.Error(exception)
        }catch (exception : HttpException){

            LoadResult.Error(exception)
        }
    }
}