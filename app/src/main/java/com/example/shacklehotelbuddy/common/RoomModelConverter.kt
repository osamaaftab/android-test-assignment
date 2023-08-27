package com.example.shacklehotelbuddy.common

import androidx.room.TypeConverter
import com.example.shacklehotelbuddy.domain.model.RoomModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class RoomModelConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromRoomObjectList(myCustomObjectList: List<RoomModel>): String {
        val listType: Type = Types.newParameterizedType(List::class.java, RoomModel::class.java)
        val adapter: JsonAdapter<List<RoomModel>> = moshi.adapter(listType)
        return adapter.toJson(myCustomObjectList)
    }

    @TypeConverter
    fun toRoomObjectList(json: String): List<RoomModel> {
        val listType: Type = Types.newParameterizedType(List::class.java, RoomModel::class.java)
        val adapter: JsonAdapter<List<RoomModel>> = moshi.adapter(listType)
        return adapter.fromJson(json) ?: emptyList()
    }
}