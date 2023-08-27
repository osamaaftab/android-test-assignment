package com.example.shacklehotelbuddy.di.module


import com.example.shacklehotelbuddy.domain.repository.HistoryRepository
import com.example.shacklehotelbuddy.domain.repository.PropertyRepository
import com.example.shacklehotelbuddy.domain.usecase.GetPropertiesUseCase
import com.example.shacklehotelbuddy.domain.usecase.GetSearchHistoryUsecase
import com.example.shacklehotelbuddy.domain.usecase.StoreSearchQueryUsecase
import org.koin.dsl.module


val UseCaseModule = module {
    single { provideGetPropertiesUseCase(get()) }
    single { provideGetSearchHistoryUseCase(get(), ) }
    single { provideStoreSearchHistoryUseCase(get() ) }

}

private fun provideGetPropertiesUseCase(
    propertyRepository: PropertyRepository
): GetPropertiesUseCase {
    return GetPropertiesUseCase(propertyRepository)
}

private fun provideGetSearchHistoryUseCase(
    historyRepository: HistoryRepository,
): GetSearchHistoryUsecase {
    return GetSearchHistoryUsecase(historyRepository)
}


private fun provideStoreSearchHistoryUseCase(
    historyRepository: HistoryRepository,
): StoreSearchQueryUsecase {
    return StoreSearchQueryUsecase(historyRepository)
}