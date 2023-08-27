package com.example.shacklehotelbuddy.presentation.compose.utils

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.shacklehotelbuddy.presentation.compose.home.HorizontalDivider
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(
    label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    onDateClick: () -> Unit,

    modifier: Modifier
) {
    HorizontalDivider()
    TextField(
        value = value,
        enabled = false,
        modifier = modifier
            .clickable { onDateClick() },

        onValueChange = { onValueChange(value) },
        placeholder = {
            Text(
                text = stringResource(label),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText
            )
        },
        textStyle = ShackleHotelBuddyTheme.typography.bodyMedium,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}