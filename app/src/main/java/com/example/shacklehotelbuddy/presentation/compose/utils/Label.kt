package com.example.shacklehotelbuddy.presentation.compose.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme

@Composable
fun Label(
    label: Int,
    icon: Int
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = stringResource(label),
        modifier = Modifier
            .height(20.dp)
            .width(20.dp)
    )

    Spacer(modifier = Modifier.width(8.dp))

    Text(
        text = stringResource(label),
        style = ShackleHotelBuddyTheme.typography.bodyMedium,
        color = ShackleHotelBuddyTheme.colors.grayText
    )
}