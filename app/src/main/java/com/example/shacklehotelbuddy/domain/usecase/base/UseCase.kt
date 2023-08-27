package com.example.shacklehotelbuddy.domain.usecase.base

import com.example.shacklehotelbuddy.domain.model.ErrorModel
import com.example.shacklehotelbuddy.domain.model.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class UseCase<ReturnType, in Params> where ReturnType : Any {
    abstract suspend fun run(params: Params? = null): Flow<Resource<ReturnType>>

    fun invoke(
        scope: CoroutineScope, params: Params?,
        onSuccess: (ReturnType) -> Unit, onError: (ErrorModel?) -> Unit
    ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                run(params)
            }.let { flow ->
                flow.collect {
                    when (it) {
                        is Resource.Error -> onError(it.errorModel)
                        is Resource.Success -> it.data?.let { data -> onSuccess(data) }
                    }
                }
            }
        }
    }
}