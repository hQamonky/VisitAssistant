package com.qmk.property_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NeighborhoodEntity(
    @PrimaryKey var neighborhoodId: Int? = null,
    var neighborhoodName: String? = null,
    var averagePricePerSquareMeter: Int? = null
)
