package com.qmk.visit_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(
    @PrimaryKey var locationId: Int? = null,
    var address: String? = null,
    @Embedded var neighborhood: NeighborhoodEntity? = null
)
