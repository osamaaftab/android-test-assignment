package com.example.shacklehotelbuddy.presentation.compose.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.model.ChildrenModel
import com.example.shacklehotelbuddy.domain.model.DateModel
import com.example.shacklehotelbuddy.domain.model.RoomModel
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.presentation.compose.utils.Button
import com.example.shacklehotelbuddy.presentation.compose.utils.DateManager.getDateModel
import com.example.shacklehotelbuddy.presentation.compose.utils.DateManager.getMillisFromDayMonthYear
import com.example.shacklehotelbuddy.presentation.compose.utils.DateManager.showDatePickerDialog
import com.example.shacklehotelbuddy.presentation.compose.utils.DateTextField
import com.example.shacklehotelbuddy.presentation.compose.utils.InputTextField
import com.example.shacklehotelbuddy.presentation.compose.utils.Label
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.theme.White
import com.example.shacklehotelbuddy.presentation.viewmodel.PropertyViewModel


@Composable
fun HomeScreen(
    propertyViewModel: PropertyViewModel,
    onSearchClick: (SearchQueryModel, Boolean) -> Unit
) {
    HomeScreen(
        searchHistoryList = propertyViewModel.getHistoryDataState.collectAsState().value,
        onSearchClick = onSearchClick
    )
}

@Composable
fun HomeScreen(
    searchHistoryList: List<SearchQueryModel>,
    onSearchClick: (SearchQueryModel, Boolean) -> Unit = { _, _ -> }
) {
    val context = LocalContext.current
    var checkInDateText by remember { mutableStateOf("") }
    var checkOutDateText by remember { mutableStateOf("") }
    var adultText by remember { mutableStateOf("") }
    var childrenText by remember { mutableStateOf("") }
    var isCheckInFieldFilled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillWidth
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.9f, true),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(26.dp),
                    text = stringResource(R.string.select_guest),
                    fontSize = 45.sp,
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.white
                )

                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = White),
                    shape = RoundedCornerShape(16.dp),
                ) {

                    Column {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(60.dp)
                        ) {

                            val modifier = (Modifier
                                .fillMaxWidth()
                                .weight(1f))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(16.dp)
                            ) {
                                Label(R.string.check_in_date, R.drawable.event_upcoming)
                            }

                            DateTextField(
                                label = R.string.date_format,
                                value = checkInDateText,
                                onValueChange = {
                                    checkInDateText = it
                                },
                                onDateClick = {
                                    showDatePickerDialog(
                                        context,
                                        checkInDateText,
                                        System.currentTimeMillis()
                                    ) {
                                        checkInDateText = it
                                        checkOutDateText = ""
                                        isCheckInFieldFilled = true
                                    }
                                }, modifier
                            )
                        }

                        VerticalDivider()

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(60.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(16.dp)
                            ) {
                                Label(R.string.check_out_date, R.drawable.event_available)
                            }

                            val modifier = (
                                    Modifier
                                        .fillMaxWidth()
                                        .weight(1f))
                            DateTextField(
                                label = R.string.date_format,
                                value = checkOutDateText,
                                onValueChange = { checkOutDateText = it },
                                onDateClick = {
                                    if (isCheckInFieldFilled) {
                                        showDatePickerDialog(
                                            context, checkOutDateText,
                                            getMillisFromDayMonthYear(
                                                getDateModel(
                                                    checkInDateText
                                                )
                                            )
                                        ) {
                                            checkOutDateText = it
                                        }
                                    }
                                }, modifier
                            )
                        }

                        VerticalDivider()

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(60.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(16.dp)
                            ) {
                                Label(R.string.adults, R.drawable.person)
                            }

                            val modifier = (
                                    Modifier
                                        .fillMaxWidth()
                                        .weight(1f))

                            InputTextField(
                                R.string.zero, adultText,
                                onValueChange = { adultText = it },
                                modifier
                            )
                        }

                        VerticalDivider()

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.height(60.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(16.dp)
                            ) {
                                Label(R.string.children, R.drawable.supervisor_account)
                            }


                            val modifier = (
                                    Modifier
                                        .fillMaxWidth()
                                        .weight(1f))

                            InputTextField(
                                R.string.zero, childrenText,
                                onValueChange = { childrenText = it },
                                modifier
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(16.dp, 12.dp, 0.dp, 8.dp),
                    text = stringResource(R.string.recent_searches),
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.white
                )

                LazyColumn(modifier = Modifier.weight(0.3f, true)) {
                    items(searchHistoryList) {
                        SearchHistoryItem(
                            searchQueryModel = it
                        ) { searchQuery ->
                            onSearchClick(searchQuery, false)
                        }
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.1f, true),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Button(stringResource(R.string.search)) {
                        if ((checkInDateText.isNotEmpty() && checkOutDateText.isNotEmpty()) && ((adultText.isNotEmpty() && !adultText.contentEquals(
                                "0"
                            )) && childrenText.isNotEmpty())
                        ) {
                            onSearchClick(
                                SearchQueryModel(
                                    checkInDate = getDateModel(checkInDateText),
                                    checkOutDate = getDateModel(checkOutDateText),
                                    rooms = listOf(
                                        RoomModel(
                                            adults = adultText.toInt(), children =
                                            List(childrenText.toInt()) { ChildrenModel() }
                                        )
                                    )
                                ), true
                            )
                        } else {
                           Toast.makeText(context,R.string.check_input,Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GalleryScreenPreview(
    @PreviewParameter(HomeScreenPreviewParamProvider::class) searchHistoryList: List<SearchQueryModel>
) {
    HomeScreen(searchHistoryList = searchHistoryList)
}

private class HomeScreenPreviewParamProvider :
    PreviewParameterProvider<List<SearchQueryModel>> {

    override val values: Sequence<List<SearchQueryModel>> =
        sequenceOf(
            listOf(
                SearchQueryModel(
                    DateModel(15, 2, 2023), DateModel(20, 2, 2023), listOf(
                        RoomModel(3, listOf(ChildrenModel(), ChildrenModel()))
                    )
                )
            )
        )
}


@Composable
fun VerticalDivider() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(ShackleHotelBuddyTheme.colors.grayBorder)
    )
}

@Composable
fun HorizontalDivider() {
    Spacer(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(ShackleHotelBuddyTheme.colors.grayBorder)
    )
}
