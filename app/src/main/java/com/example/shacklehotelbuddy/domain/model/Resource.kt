package com.example.shacklehotelbuddy.domain.model

sealed class Resource<T>(val data: T? = null, val errorModel: ErrorModel? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null, errorModel: ErrorModel) : Resource<T>(data, errorModel)
}