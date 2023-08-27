package com.example.shacklehotelbuddy.presentation.compose.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.presentation.viewmodel.PropertyViewModel
import com.example.shacklehotelbuddy.domain.model.ImageModel
import com.example.shacklehotelbuddy.domain.model.LocationModel
import com.example.shacklehotelbuddy.domain.model.PriceLeadModel
import com.example.shacklehotelbuddy.domain.model.PropertyImageModel
import com.example.shacklehotelbuddy.domain.model.PropertyModel
import com.example.shacklehotelbuddy.domain.model.PropertyPriceModel
import com.example.shacklehotelbuddy.domain.model.PropertyReviewModel
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme

@Composable
fun SearchResultScreen(
    propertyViewModel: PropertyViewModel,
    onBackClick: () -> Unit
) {
    SearchResultScreen(
        loadingState = propertyViewModel.getLoadingState.collectAsState().value,
        propertyList = propertyViewModel.getPropertiesDataState.collectAsState().value,
        errorState = propertyViewModel.getErrorState.collectAsState().value,
        onBackClick = onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultScreen(
    loadingState: Boolean,
    propertyList: List<PropertyModel>,
    errorState: Boolean,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.search_results),
                        color = Color.Black,
                        style = ShackleHotelBuddyTheme.typography.bodyMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackClick()
                    }
                    ) {
                        Icon(Icons.Outlined.ArrowBack, null, tint = Color.Black)
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            if (!loadingState) {
                if (!errorState) {
                    if (propertyList.isNotEmpty()) {
                        PropertyList(propertyList)
                    } else {
                        ShowMessage(stringResource(R.string.no_properties))
                    }
                } else {
                    ShowMessage(stringResource(R.string.no_network))
                }
            } else {
                ShowProgressBar()
            }
        }
    }
}

@Composable
fun PropertyList(propertiesList: List<PropertyModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = propertiesList) { lazyItem ->
            PropertyItem(propertyModel = lazyItem)
        }
    }
}

@Composable
fun ShowProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ShowMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = ShackleHotelBuddyTheme.typography.bodyMedium,
            color = ShackleHotelBuddyTheme.colors.grayText
        )
    }
}


@Preview
@Composable
private fun SearchResultScreenPreview(
    @PreviewParameter(SearchResultScreenPreviewParamProvider::class) propertyList: List<PropertyModel>
) {
    SearchResultScreen(loadingState = false, propertyList = propertyList,errorState = false)
}

private class SearchResultScreenPreviewParamProvider :
    PreviewParameterProvider<List<PropertyModel>> {

    override val values: Sequence<List<PropertyModel>> =
        sequenceOf(
            listOf(
                PropertyModel(
                    "123",
                    "Awesome Place to Visit",
                    PropertyImageModel(ImageModel(url = "https://images.trvl-media.com/lodging/5000000/4760000/4757600/4757569/fdecba1e.jpg?impolicy=resizecrop&rw=455&ra=fit")),
                    LocationModel("Some where in Earth"),
                    PropertyPriceModel(PriceLeadModel("$102")),
                    PropertyReviewModel("8.5")
                )
            )
        )
}

