package com.example.shacklehotelbuddy.di.module

import com.example.shacklehotelbuddy.data.source.local.SearchHistoryLocalDataSource
import com.example.shacklehotelbuddy.data.ShackleDb
import org.koin.dsl.module

val LocalDataSourceModule = module {
    single { provideSearchHistoryDataSource(get()) }
}

fun provideSearchHistoryDataSource(
    shackleDb: ShackleDb
): SearchHistoryLocalDataSource {
    return SearchHistoryLocalDataSource(shackleDb)
}