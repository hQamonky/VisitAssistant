package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NeighborhoodEntity(
    @PrimaryKey var neighborhoodId: Int? = null,
    var name: String? = null,
    var averagePricePerSquareMeter: Int? = null
)
