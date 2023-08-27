package com.example.shacklehotelbuddy.domain.repository

import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getSearchHistory(): Flow<Resource<List<SearchQueryModel>>>
    suspend fun storeSearchQuery(searchQueryModel: SearchQueryModel): Flow<Resource<Unit>>
}