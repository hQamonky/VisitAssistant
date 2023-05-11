package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.NeighborhoodEntity
import com.qmk.property_domain.model.Neighborhood

fun NeighborhoodEntity.toNeighborhood(): Neighborhood {
    return Neighborhood(
        name = neighborhoodName,
        averagePricePerSquareMeter = averagePricePerSquareMeter
    )
}

fun Neighborhood.toEntity(): NeighborhoodEntity {
    return NeighborhoodEntity(
        neighborhoodName = name,
        averagePricePerSquareMeter = averagePricePerSquareMeter
    )
}