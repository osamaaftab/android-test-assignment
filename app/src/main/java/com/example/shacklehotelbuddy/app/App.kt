package com.example.shacklehotelbuddy.app

import android.app.Application
import com.example.shacklehotelbuddy.di.module.ApiServicesModule
import com.example.shacklehotelbuddy.di.module.AppModule
import com.example.shacklehotelbuddy.di.module.LocalDataSourceModule
import com.example.shacklehotelbuddy.di.module.NetWorkModule
import com.example.shacklehotelbuddy.di.module.RemoteDataSourceModule
import com.example.shacklehotelbuddy.di.module.RepositoryModule
import com.example.shacklehotelbuddy.di.module.UseCaseModule
import com.example.shacklehotelbuddy.di.module.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    ApiServicesModule,
                    AppModule,
                    NetWorkModule,
                    RepositoryModule,
                    UseCaseModule,
                    ViewModelModule,
                    RemoteDataSourceModule,
                    LocalDataSourceModule,
                )
            )
        }
    }
}