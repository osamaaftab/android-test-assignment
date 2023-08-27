package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.repository.HistoryRepository
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import com.example.shacklehotelbuddy.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow

class GetSearchHistoryUsecase constructor(
    private val historyRepository: HistoryRepository) : UseCase<List<SearchQueryModel>, Unit>() {
    override suspend fun run(params: Unit?): Flow<Resource<List<SearchQueryModel>>> {
        return historyRepository.getSearchHistory()
    }
}