package com.example.shacklehotelbuddy.di.module

import com.example.shacklehotelbuddy.data.service.PropertyServices
import org.koin.dsl.module
import retrofit2.Retrofit

val ApiServicesModule = module {
    single { providePropertyService(get()) }
}

private fun providePropertyService(retrofit: Retrofit): PropertyServices {
    return retrofit.create(PropertyServices::class.java)
}

