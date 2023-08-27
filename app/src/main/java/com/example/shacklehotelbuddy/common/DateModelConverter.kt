package com.example.shacklehotelbuddy.common

import androidx.room.TypeConverter
import com.example.shacklehotelbuddy.domain.model.DateModel
import com.squareup.moshi.Moshi

class DateModelConverter {

    @TypeConverter
    fun stringToDateModel(input: String?): DateModel? =
        input?.let { Moshi.Builder().build().adapter(DateModel::class.java).fromJson(it) }

    @TypeConverter
    fun dateModelToString(dateModel: DateModel): String? =
        Moshi.Builder().build().adapter(DateModel::class.java).toJson(dateModel)
}