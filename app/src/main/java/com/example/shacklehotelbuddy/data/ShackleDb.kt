package com.example.shacklehotelbuddy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shacklehotelbuddy.common.ChildrenModelConverter
import com.example.shacklehotelbuddy.common.DateModelConverter
import com.example.shacklehotelbuddy.common.RoomModelConverter
import com.example.shacklehotelbuddy.data.source.base.HistoryDataSource
import com.example.shacklehotelbuddy.domain.model.SearchQueryModel

@Database(entities = [SearchQueryModel::class], version = 1)
@TypeConverters(DateModelConverter::class, RoomModelConverter::class,ChildrenModelConverter::class)
abstract class ShackleDb : RoomDatabase() {
    abstract fun searchHistoryDao(): HistoryDataSource
}
