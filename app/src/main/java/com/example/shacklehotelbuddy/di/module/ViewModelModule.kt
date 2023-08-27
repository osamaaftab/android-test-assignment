package com.example.shacklehotelbuddy.di.module

import com.example.shacklehotelbuddy.presentation.viewmodel.PropertyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { PropertyViewModel(get(), get(), get()) }
}