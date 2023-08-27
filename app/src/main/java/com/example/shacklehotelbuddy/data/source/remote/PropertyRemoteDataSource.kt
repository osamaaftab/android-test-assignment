package com.example.shacklehotelbuddy.data.source.remote

import com.example.shacklehotelbuddy.data.service.PropertyServices
import com.example.shacklehotelbuddy.data.source.base.PropertyDataSource
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import kotlinx.coroutines.Deferred

class PropertyRemoteDataSource(private val propertyServices: PropertyServices) : PropertyDataSource {
    override suspend fun getPropertiesAsync(searchQueryModel: SearchQueryModel): Deferred<ResponseModel> {
       return propertyServices.getPropertiesAsync(searchQueryModel)
    }
}