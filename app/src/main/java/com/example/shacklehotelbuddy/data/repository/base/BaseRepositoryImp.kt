package com.example.shacklehotelbuddy.data.repository.base

import com.example.shacklehotelbuddy.data.ApiErrorHandle
import com.example.shacklehotelbuddy.domain.model.Resource
import kotlinx.coroutines.Deferred

open class BaseRepositoryImp(private val errorHandle: ApiErrorHandle) {

    protected suspend fun <T> Deferred<T>.awaitAndCatch(): Resource<T> {
        return try {
            Resource.Success(this.await())
        } catch (e: Exception) {
            return Resource.Error(errorModel = errorHandle.traceErrorException(e))
        }
    }

    fun <E> List<E>.tryAndCatch(): Resource<List<E>> {
        return try {
            Resource.Success(this)
        } catch (e: Exception) {
            return Resource.Error(errorModel = errorHandle.traceErrorException(e))
        }
    }

    fun Unit.tryAndCatch(): Resource<Unit> {
        return try {
            Resource.Success(this)
        } catch (e: Exception) {
            return Resource.Error(errorModel = errorHandle.traceErrorException(e))
        }
    }
}