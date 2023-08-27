package com.example.shacklehotelbuddy.di.module

import com.example.shacklehotelbuddy.data.ApiErrorHandle
import com.example.shacklehotelbuddy.data.repository.HistoryRepositoryImp
import com.example.shacklehotelbuddy.data.repository.PropertyRepositoryImp
import com.example.shacklehotelbuddy.data.source.base.HistoryDataSource
import com.example.shacklehotelbuddy.data.source.base.PropertyDataSource
import com.example.shacklehotelbuddy.data.source.local.SearchHistoryLocalDataSource
import com.example.shacklehotelbuddy.data.source.remote.PropertyRemoteDataSource
import com.example.shacklehotelbuddy.domain.repository.HistoryRepository
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { providePropertyRepository(get(), get()) }
    single { provideHistoryRepository(get(), get()) }

}

fun providePropertyRepository(
    propertyRemoteDataSource: PropertyRemoteDataSource,
    errorHandle: ApiErrorHandle
): PropertyRepository {
    return PropertyRepositoryImp(propertyRemoteDataSource, errorHandle)
}

fun provideHistoryRepository(
    searchHistoryLocalDataSource: SearchHistoryLocalDataSource,
    errorHandle: ApiErrorHandle
): HistoryRepository {
    return HistoryRepositoryImp(searchHistoryLocalDataSource, errorHandle)
}