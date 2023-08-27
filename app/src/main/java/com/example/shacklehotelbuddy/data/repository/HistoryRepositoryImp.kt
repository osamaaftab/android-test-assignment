package com.example.shacklehotelbuddy.data.repository

import com.example.shacklehotelbuddy.data.ApiErrorHandle
import com.example.shacklehotelbuddy.data.repository.base.BaseRepositoryImp
import com.example.shacklehotelbuddy.data.source.local.SearchHistoryLocalDataSource
import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryRepositoryImp(
    private val historyDataSource: SearchHistoryLocalDataSource,
    errorHandle: ApiErrorHandle
) : HistoryRepository, BaseRepositoryImp(errorHandle) {

    override suspend fun getSearchHistory(): Flow<Resource<List<SearchQueryModel>>> = flow {
        emit(historyDataSource.getSearchHistoryAsync().tryAndCatch())
    }

    override suspend fun storeSearchQuery(searchQueryModel: SearchQueryModel): Flow<Resource<Unit>> =
        flow {
            emit(historyDataSource.storeSearchQueryAsync(searchQueryModel).tryAndCatch())
        }
}
