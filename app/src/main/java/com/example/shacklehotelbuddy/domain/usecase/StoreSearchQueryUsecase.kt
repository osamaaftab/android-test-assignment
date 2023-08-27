package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.repository.HistoryRepository
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import com.example.shacklehotelbuddy.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow

class StoreSearchQueryUsecase constructor(
    private val historyRepository: HistoryRepository) : UseCase<Unit, SearchQueryModel>() {
    override suspend fun run(params: SearchQueryModel?): Flow<Resource<Unit>> {
        if (params == null) {
            throw IllegalArgumentException("Param must not be null")
        }
        return historyRepository.storeSearchQuery(params)
    }
}