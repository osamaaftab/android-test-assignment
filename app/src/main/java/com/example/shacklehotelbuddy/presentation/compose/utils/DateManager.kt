package com.example.shacklehotelbuddy.presentation.compose.utils

import android.app.DatePickerDialog
import android.content.Context
import com.example.shacklehotelbuddy.domain.model.DateModel
import java.util.Calendar

object DateManager {

    fun getDateModel(date: String): DateModel {
        val dateParts: List<String> = date.split("/")
        val day = dateParts[0]
        val month = dateParts[1]
        val year = dateParts[2]
        return DateModel(day.toInt(), month.toInt(), year.toInt())
    }

    fun getDateString(date: DateModel): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(date.day.toString() + "/")
        stringBuilder.append(date.month.toString() + "/")
        stringBuilder.append(date.year.toString())
        return stringBuilder.toString()
    }

    fun getMillisFromDayMonthYear(date: DateModel): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, date.year)
        calendar.set(Calendar.MONTH, date.month - 1)
        calendar.set(Calendar.DAY_OF_MONTH, date.day)

        return calendar.timeInMillis
    }

    fun showDatePickerDialog(
        context: Context,
        existingDate: String,
        minDate: Long,
        onSelected: (String) -> Unit
    ) {
        val year: Int
        val month: Int
        val dayOfMonth: Int

        if (existingDate.isEmpty()) {
            val calendar = Calendar.getInstance()
            year = calendar[Calendar.YEAR]
            month = calendar[Calendar.MONTH]
            dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        } else {
            val date = getDateModel(existingDate)
            year = date.year
            month = date.month
            dayOfMonth = date.day
        }


        val datePickerDialog = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val formattedDate = "${selectedDayOfMonth}/${selectedMonth + 1}/${selectedYear}"
                onSelected(formattedDate)
            },
            year, month - 1, dayOfMonth
        )
        datePickerDialog.datePicker.minDate = minDate - 1000
        datePickerDialog.show()
    }

}