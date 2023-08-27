package com.example.shacklehotelbuddy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shacklehotelbuddy.presentation.compose.ShackleApp
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShackleHotelBuddyTheme {
                ShackleApp()
            }
        }
    }
}