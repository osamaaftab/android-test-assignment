package com.example.shacklehotelbuddy.presentation.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Teal = Color(0xFF2CABB1)
val GrayBorder = Color(0xFFDDDDDD)
val GrayText = Color(0xFF6D6D6D)

class CustomColors(
    black: Color,
    white: Color,
    teal: Color,
    grayBorder: Color,
    grayText: Color
) {
    var black by mutableStateOf(black)
        private set

    var white by mutableStateOf(white)
        private set

    var teal by mutableStateOf(teal)
        private set

    var grayBorder by mutableStateOf(grayBorder)
        private set

    var grayText by mutableStateOf(grayText)
        private set

    fun copy(
        black: Color = this.black,
        white: Color = this.white,
        teal: Color = this.teal,
        grayBorder: Color = this.grayBorder,
        grayText: Color = this.grayText,
    ): CustomColors = CustomColors(
        black = black,
        white = white,
        teal = teal,
        grayBorder = grayBorder,
        grayText = grayText,
    )

    fun updateColorsFrom(other: CustomColors) {
        with(other) {
            black = black
            white = white
            teal = teal
            grayBorder = grayBorder
            grayText = grayText
        }
    }
}

val LocalColors = staticCompositionLocalOf {
    CustomColors(
        black = Black,
        white = White,
        teal = Teal,
        grayBorder = GrayBorder,
        grayText = GrayText
    )
}