package com.example.shacklehotelbuddy.domain.repository

import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    suspend fun getProperties(searchQueryModel: SearchQueryModel): Flow<Resource<ResponseModel>>
}