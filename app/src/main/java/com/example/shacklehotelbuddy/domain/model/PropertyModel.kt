package com.example.shacklehotelbuddy.domain.model

data class PropertyModel(
    val id: String,
    val name: String,
    val propertyImage: PropertyImageModel,
    val neighborhood: LocationModel,
    val price: PropertyPriceModel,
    val reviews: PropertyReviewModel
)

data class PropertyImageModel(val image: ImageModel)
data class ImageModel(val url: String)
data class LocationModel(val name: String)
data class PropertyPriceModel(val lead: PriceLeadModel)
data class PriceLeadModel(val formatted: String)
data class PropertyReviewModel(val score: String)