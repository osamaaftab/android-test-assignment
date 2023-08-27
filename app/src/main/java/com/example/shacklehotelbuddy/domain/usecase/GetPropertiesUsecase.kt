package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import com.example.shacklehotelbuddy.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow

class GetPropertiesUseCase constructor(
    private val propertyRepository: PropertyRepository) : UseCase<ResponseModel, SearchQueryModel>() {
    override suspend fun run(params: SearchQueryModel?): Flow<Resource<ResponseModel>> {
        if (params == null) {
            throw IllegalArgumentException("Param must not be null")
        }
        return propertyRepository.getProperties(params)
    }
}