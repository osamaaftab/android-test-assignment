package com.example.shacklehotelbuddy.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.presentation.viewmodel.PropertyViewModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.presentation.compose.home.HomeScreen
import com.example.shacklehotelbuddy.presentation.compose.search.SearchResultScreen
import com.squareup.moshi.Moshi
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShackleApp() {
    val navController = rememberNavController()
    ShackleNavHost(
        navController = navController
    )
}

@Composable
fun ShackleNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            val propertyViewModel: PropertyViewModel = koinViewModel()

            HomeScreen(propertyViewModel) { searchParam, shouldLocallyStore ->
                if (shouldLocallyStore) {
                    propertyViewModel.storeQueryToSearchHistory(searchParam)
                }
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set(
                        "searchParam",
                        Moshi.Builder().build().adapter(SearchQueryModel::class.java)
                            .toJson(searchParam)
                    )
                }
                navController.navigate("searchResult")
            }
        }

        composable("searchResult") {
            val propertyViewModel: PropertyViewModel = koinViewModel()

            val searchQueryJson =
                navController.previousBackStackEntry?.savedStateHandle?.get<String>("searchParam")
            searchQueryJson?.let {
                val searchQuery =
                    Moshi.Builder().build().adapter(SearchQueryModel::class.java).fromJson(it)

                if (searchQuery != null) {
                    propertyViewModel.loadPropertyList(searchQuery)
                }

                SearchResultScreen(propertyViewModel) {
                    navController.popBackStack()
                }
            }
        }
    }
}