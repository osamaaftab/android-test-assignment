package com.example.shacklehotelbuddy.data.repository

import com.example.shacklehotelbuddy.data.ApiErrorHandle
import com.example.shacklehotelbuddy.data.repository.base.BaseRepositoryImp
import com.example.shacklehotelbuddy.data.source.remote.PropertyRemoteDataSource
import com.example.shacklehotelbuddy.domain.model.Resource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PropertyRepositoryImp(
    private val propertyRemoteDataSource: PropertyRemoteDataSource,
    errorHandle: ApiErrorHandle
) : PropertyRepository, BaseRepositoryImp(errorHandle) {

    override suspend fun getProperties(searchQueryModel: SearchQueryModel): Flow<Resource<ResponseModel>> = flow {
        emit(propertyRemoteDataSource.getPropertiesAsync(searchQueryModel).awaitAndCatch())
    }
}