package com.example.shacklehotelbuddy.data.service

import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface PropertyServices {
    @POST("properties/v2/list")
    fun getPropertiesAsync(@Body searchQueryModel: SearchQueryModel): Deferred<ResponseModel>
}