package com.example.shacklehotelbuddy.data.source.base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel

@Dao
interface HistoryDataSource {

    @Query("SELECT * FROM search_history ORDER BY timestamp DESC")
    suspend fun getSearchHistoryAsync(): List<SearchQueryModel>

    @Insert
    suspend fun storeSearchQueryAsync(searchQueryModel: SearchQueryModel)
}