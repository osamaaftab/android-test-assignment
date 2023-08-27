package com.example.shacklehotelbuddy.presentation.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel
import com.example.shacklehotelbuddy.presentation.compose.utils.DateManager.getDateString
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchHistoryItem(
    searchQueryModel: SearchQueryModel,
    onHistoryClickListener: (SearchQueryModel) -> Unit
) {
    Card(
        modifier = Modifier
            .absolutePadding(16.dp, 6.dp, 16.dp, 6.dp)
            .fillMaxWidth()
            .height(48.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onHistoryClickListener(searchQueryModel)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(8.dp, 0.dp, 8.dp, 0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.manage_history),
                contentDescription = "",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                text = "${getDateString(searchQueryModel.checkInDate)} - ${
                    getDateString(
                        searchQueryModel.checkOutDate
                    )
                }    ${searchQueryModel.rooms.first().adults} adult, ${searchQueryModel.rooms.first().children.size} children",
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
            )
        }
    }
}