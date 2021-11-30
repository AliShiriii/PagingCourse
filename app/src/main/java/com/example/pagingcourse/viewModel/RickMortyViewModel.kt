package com.example.pagingcourse.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingcourse.api.ApiService
import com.example.pagingcourse.models.RickMorty
import com.example.pagingcourse.paging.RickMortyPagingSource
import com.example.pagingcourse.repository.RickMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor
    (private val apiService: ApiService) : ViewModel() {


    val rickMortyData = Pager(
        config = PagingConfig(pageSize = 1, enablePlaceholders = false)
    ){

        RickMortyPagingSource(apiService)

    }.flow.cachedIn(viewModelScope)

//    val rickMortyData =
//
//        viewModelScope.launch {
//
//            rickMortyRepository.getRick()
//
//        }
}