package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.*
import com.qmk.property_domain.model.Location
import com.qmk.property_domain.model.Neighborhood
import com.qmk.property_domain.model.property.Annex
import com.qmk.property_domain.model.property.Apartment
import com.qmk.property_domain.model.property.House
import com.qmk.property_domain.model.property.Property

fun PropertyEntity.toProperty(): Property? {
    return when(this.propertyType) {
        PropertyType.APARTMENT -> Apartment(
            id = propertyId,
            marketPrice = marketPrice,
            location = location?.let { locationEntity ->
                Location(
                    id = locationEntity.locationId,
                    streetNumber = locationEntity.streetNumber,
                    streetName = locationEntity.streetName,
                    neighborhood = locationEntity.neighborhood?.let { neighborhoodEntity ->
                        Neighborhood(
                            name = neighborhoodEntity.name,
                            averagePricePerSquareMeter = neighborhoodEntity.averagePricePerSquareMeter
                        )
                    },
                    postalCode = locationEntity.postalCode,
                    city = locationEntity.city,
                    country = locationEntity.country,
                    latitude = locationEntity.latitude,
                    longitude = locationEntity.longitude
                )
            },
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoom() },
            annex = annex?.map { it.toAnnex() },
            services = services,
            propertyTax = propertyTax,
            media = propertyMedia,
            notes = propertyNotes,
            floor = floor,
            buildingFloors = buildingFloors,
            lift = lift,
            condominiumFees = condominiumFees
        )
        PropertyType.HOUSE -> House(
            id = propertyId,
            marketPrice = marketPrice,
            location = location?.let { locationEntity ->
                Location(
                    id = locationEntity.locationId,
                    streetNumber = locationEntity.streetNumber,
                    streetName = locationEntity.streetName,
                    neighborhood = locationEntity.neighborhood?.let { neighborhoodEntity ->
                        Neighborhood(
                            name = neighborhoodEntity.name,
                            averagePricePerSquareMeter = neighborhoodEntity.averagePricePerSquareMeter
                        )
                    },
                    postalCode = locationEntity.postalCode,
                    city = locationEntity.city,
                    country = locationEntity.country,
                    latitude = locationEntity.latitude,
                    longitude = locationEntity.longitude
                )
            },
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoom() },
            annex = annex?.map { it.toAnnex() },
            services = services,
            propertyTax = propertyTax,
            media = propertyMedia,
            notes = propertyNotes,
            floors = floors,
            landSurface = landSurface
        )
        PropertyType.UNKNOWN -> null
    }
}

fun AnnexEntity.toAnnex(): Annex {
    return Annex(
        surface = surface,
        type = annexType
    )
}

fun Property.toEntity(): PropertyEntity {
    return when(this) {
        is Apartment -> PropertyEntity(
            propertyId = id,
            propertyType = PropertyType.APARTMENT,
            marketPrice = marketPrice,
            location = location?.let {
                LocationEntity(
                    locationId = it.id,
                    streetNumber = it.streetNumber,
                    streetName = it.streetName,
                    neighborhood = it.neighborhood?.let { neighborhood ->
                        NeighborhoodEntity(
                            name = neighborhood.name,
                            averagePricePerSquareMeter = neighborhood.averagePricePerSquareMeter
                        )
                    },
                    postalCode = it.postalCode,
                    city = it.city,
                    country = it.country,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            },
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoomEntity() },
            annex = annex?.map { it.toAnnexEntity() },
            services = services,
            propertyTax = propertyTax,
            propertyMedia = media,
            propertyNotes = notes,
            floor = floor,
            buildingFloors = buildingFloors,
            lift = lift,
            condominiumFees = condominiumFees,
            floors = null,
            landSurface = null
        )
        is House -> PropertyEntity(
            propertyId = id,
            propertyType = PropertyType.HOUSE,
            marketPrice = marketPrice,
            location = location?.let {
                LocationEntity(
                    locationId = it.id,
                    streetNumber = it.streetNumber,
                    streetName = it.streetName,
                    neighborhood = it.neighborhood?.let { neighborhood ->
                        NeighborhoodEntity(
                            name = neighborhood.name,
                            averagePricePerSquareMeter = neighborhood.averagePricePerSquareMeter
                        )
                    },
                    postalCode = it.postalCode,
                    city = it.city,
                    country = it.country,
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            },
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoomEntity() },
            annex = annex?.map { it.toAnnexEntity() },
            services = services,
            propertyTax = propertyTax,
            propertyMedia = media,
            propertyNotes = notes,
            floor = null,
            buildingFloors = null,
            lift = null,
            condominiumFees = null,
            floors = floors,
            landSurface = landSurface
        )
        else -> PropertyEntity()
    }
}

fun Annex.toAnnexEntity(): AnnexEntity {
    return AnnexEntity(
        surface = surface,
        annexType = type
    )
}