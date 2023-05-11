package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.LocationEntity
import com.qmk.property_domain.model.Location

fun LocationEntity.toLocation(): Location {
    return Location(
        id = locationId,
        streetNumber = streetNumber,
        streetName = streetName,
        neighborhood = neighborhood?.toNeighborhood(),
        postalCode = postalCode,
        city = city,
        country = country,
        latitude = latitude,
        longitude = longitude
    )
}

fun Location.toEntity(): LocationEntity {
    return LocationEntity(
        locationId = id,
        streetNumber = streetNumber,
        streetName = streetName,
        neighborhood = neighborhood?.toEntity(),
        postalCode = postalCode,
        city = city,
        country = country,
        latitude = latitude,
        longitude = longitude
    )
}