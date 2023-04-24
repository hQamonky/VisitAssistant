package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(
    @PrimaryKey var locationId: Int? = null,
    val streetNumber: Int? = null,
    val streetName: String? = null,
    @Embedded var neighborhood: NeighborhoodEntity? = null,
    val postalCode: String? = null,
    val city: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
)
