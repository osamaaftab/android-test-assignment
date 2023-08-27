package com.example.shacklehotelbuddy.data.source.local

import com.example.shacklehotelbuddy.data.ShackleDb
import com.example.shacklehotelbuddy.data.source.base.HistoryDataSource
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel

class SearchHistoryLocalDataSource(private val shackleDb: ShackleDb) : HistoryDataSource {

    override suspend fun getSearchHistoryAsync(): List<SearchQueryModel> {
        return shackleDb.searchHistoryDao().getSearchHistoryAsync()
    }

    override suspend fun storeSearchQueryAsync(searchQueryModel: SearchQueryModel) {
        return shackleDb.searchHistoryDao().storeSearchQueryAsync(searchQueryModel)
    }
}