package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class PropertyEntity(
    @PrimaryKey var propertyId: Int? = null,
    var propertyType: PropertyType = PropertyType.UNKNOWN,
    var marketPrice: Int? = null,
    @Embedded var location: LocationEntity? = null,
    var surface: Double? = null,
    var orientation: com.qmk.property_domain.model.Orientation? = null,
    @Ignore var rooms: List<RoomEntity>? = null,
    @Ignore var annex: List<AnnexEntity>? = null,
    var services: com.qmk.property_domain.model.property.PublicService? = null,
    var propertyTax: Int? = null,
    var propertyMedia: List<String>? = null,
    var propertyNotes: String? = null,
    var floor: Int? = null,
    var buildingFloors: Int? = null,
    var lift: Boolean? = null,
    var condominiumFees: Int? = null,
    var floors: Int? = null,
    var landSurface: Int? = null
)

enum class PropertyType {
    UNKNOWN,
    APARTMENT,
    HOUSE
}