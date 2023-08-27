package com.example.shacklehotelbuddy.presentation.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shacklehotelbuddy.domain.model.ErrorModel
import com.example.shacklehotelbuddy.domain.model.PropertyModel
import com.example.shacklehotelbuddy.domain.model.ResponseModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.domain.usecase.GetPropertiesUseCase
import com.example.shacklehotelbuddy.domain.usecase.GetSearchHistoryUsecase
import com.example.shacklehotelbuddy.domain.usecase.StoreSearchQueryUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PropertyViewModel(
    private val getPropertiesUseCase: GetPropertiesUseCase,
    private val StoreSearchQueryUseCase: StoreSearchQueryUsecase,
    private val getSearchHistoryUseCase: GetSearchHistoryUsecase
) : ViewModel() {

    private val onProgressShowState = MutableStateFlow(true)

    private val onErrorShowState = MutableStateFlow(false)

    private val propertiesDataState = MutableStateFlow<List<PropertyModel>>(listOf())

    private val historyDataState = MutableStateFlow<List<SearchQueryModel>>(listOf())

    init {
        loadSearchHistoryList()
    }

    private fun getPropertiesSuccess(responseModel: ResponseModel) {
        Log.i(ContentValues.TAG, "result : ${responseModel.data?.propertySearch?.properties}")
        onProgressShowState.value = false
        propertiesDataState.value = responseModel.data?.propertySearch?.properties ?: listOf()
    }

    private fun getPropertiesFails(errorModel: ErrorModel?) {
        Log.i(ContentValues.TAG, "error status: ${errorModel?.errorStatus}")
        Log.i(ContentValues.TAG, "error message: ${errorModel?.message}")
        onProgressShowState.value = false
        onErrorShowState.value = true
    }

    fun loadPropertyList(queryModel: SearchQueryModel) {
        getPropertiesUseCase(queryModel)
    }

    private fun loadSearchHistoryList() {
        getSearchHistoryUseCase.invoke(viewModelScope, null, onSuccess = {
            historyDataState.value = it
        }, onError = {

        })
    }

    private fun getPropertiesUseCase(queryModel: SearchQueryModel) {
        getPropertiesUseCase.invoke(viewModelScope, queryModel,
            onSuccess = {
                getPropertiesSuccess(it)
            }, onError = {
                getPropertiesFails(it)
            })
    }

    val getPropertiesDataState: StateFlow<List<PropertyModel>> = propertiesDataState

    val getLoadingState: StateFlow<Boolean> = onProgressShowState

    val getHistoryDataState: StateFlow<List<SearchQueryModel>> = historyDataState

    val getErrorState: StateFlow<Boolean> = onErrorShowState

    fun storeQueryToSearchHistory(queryModel: SearchQueryModel) {
        StoreSearchQueryUseCase.invoke(viewModelScope, queryModel,
            onSuccess = {
                Log.i(ContentValues.TAG, "successfully inserted")
            }, onError = {
                Log.i(ContentValues.TAG, "error status: ${it?.errorStatus}")
            })
    }
}