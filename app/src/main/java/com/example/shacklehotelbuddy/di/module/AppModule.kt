package com.example.shacklehotelbuddy.di.module

import androidx.room.Room
import com.example.shacklehotelbuddy.data.ApiErrorHandle
import com.example.shacklehotelbuddy.data.ShackleDb
import org.koin.dsl.module

val AppModule = module {
    single { provideApiError() }
    single {
        Room.databaseBuilder(get(), ShackleDb::class.java, "app_database")
            .build()
    }
    factory { get<ShackleDb>().searchHistoryDao() }
}

fun provideApiError(): ApiErrorHandle {
    return ApiErrorHandle()
}