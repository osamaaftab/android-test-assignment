package com.example.shacklehotelbuddy.common

import androidx.room.TypeConverter
import com.example.shacklehotelbuddy.domain.model.ChildrenModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class ChildrenModelConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromChildObjectList(myCustomObjectList: List<ChildrenModel>): String {
        val listType: Type = Types.newParameterizedType(List::class.java, ChildrenModel::class.java)
        val adapter: JsonAdapter<List<ChildrenModel>> = moshi.adapter(listType)
        return adapter.toJson(myCustomObjectList)
    }

    @TypeConverter
    fun toChildObjectList(json: String): List<ChildrenModel> {
        val listType: Type = Types.newParameterizedType(List::class.java, ChildrenModel::class.java)
        val adapter: JsonAdapter<List<ChildrenModel>> = moshi.adapter(listType)
        return adapter.fromJson(json) ?: emptyList()
    }
}