package com.example.shacklehotelbuddy.di.module

import com.example.shacklehotelbuddy.data.service.PropertyServices
import com.example.shacklehotelbuddy.data.source.remote.PropertyRemoteDataSource
import org.koin.dsl.module

val RemoteDataSourceModule = module {
    single { provideRemotePropertyDataSource(get()) }
}

fun provideRemotePropertyDataSource(
    propertyServices: PropertyServices
): PropertyRemoteDataSource {
    return PropertyRemoteDataSource(propertyServices)
}