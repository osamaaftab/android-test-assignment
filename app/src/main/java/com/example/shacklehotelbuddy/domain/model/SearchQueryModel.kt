package com.example.shacklehotelbuddy.domain.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "search_history")
data class SearchQueryModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var checkInDate: DateModel,
    var checkOutDate: DateModel,
    var rooms: List<RoomModel>,
    @Ignore
    var currency: String,
    @Ignore
    var eapid: Int,
    @Ignore
    var locale: String,
    @Ignore
    var siteId: Int,
    @Ignore
    var destination: DestinationModel,
    @Ignore
    var resultsStartingIndex: Int,
    @Ignore
    var resultsSize: Int,
    @Ignore
    var sort: String,
    @Ignore
    var filters: FilterModel,
    var timestamp: Long = System.currentTimeMillis()
) {
    constructor(checkInDate: DateModel, checkOutDate: DateModel, rooms: List<RoomModel>) : this(
        0,
        checkInDate,
        checkOutDate,
        rooms,
        "USD",
        1,
        "en_US",
        300000001,
        DestinationModel(),
        0,
        200,
        "PRICE_LOW_TO_HIGH",
        FilterModel(PriceModel(150, 100)),
        System.currentTimeMillis()
    )
}
