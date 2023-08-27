package com.example.shacklehotelbuddy.presentation.compose.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.theme.Teal

@Composable
fun Button(text : String, onClick :  () -> Unit) {
    androidx.compose.material3.Button(colors = ButtonDefaults.buttonColors(containerColor = Teal),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(60.dp)
            .border(
                width = 5.dp, color = Teal,
                shape = RoundedCornerShape(20.dp)
            ),
        onClick = {
            onClick()
        }) {
        Text(
            text = text,
            style = ShackleHotelBuddyTheme.typography.bodyMedium,
            color = ShackleHotelBuddyTheme.colors.white
        )
    }
}