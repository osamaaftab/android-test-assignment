package com.example.shacklehotelbuddy.presentation.compose.utils

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.shacklehotelbuddy.presentation.compose.home.HorizontalDivider
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {

    HorizontalDivider()
    val focusManager = LocalFocusManager.current
    TextField(
        value = value,
        modifier = modifier,
        onValueChange = {
            if (value.length == 1 && value[0].isDigit()) {
                onValueChange(it)
            } else if (value.isEmpty()) {
                onValueChange(it)
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = label),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText
            )
        },
        textStyle = ShackleHotelBuddyTheme.typography.bodyMedium,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
    )
}