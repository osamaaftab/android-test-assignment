package com.example.shacklehotelbuddy.data.source.base

import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import kotlinx.coroutines.Deferred

interface PropertyDataSource {
    suspend fun getPropertiesAsync(searchQueryModel: SearchQueryModel): Deferred<ResponseModel>
}