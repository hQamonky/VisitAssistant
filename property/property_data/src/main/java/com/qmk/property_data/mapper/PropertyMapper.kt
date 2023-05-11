package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.AnnexEntity
import com.qmk.property_data.local.entity.PropertyEntity
import com.qmk.property_data.local.entity.PropertyType
import com.qmk.property_domain.model.property.Annex
import com.qmk.property_domain.model.property.Apartment
import com.qmk.property_domain.model.property.House
import com.qmk.property_domain.model.property.Property

fun PropertyEntity.toProperty(): Property? {
    return when(this.propertyType) {
        PropertyType.APARTMENT -> Apartment(
            id = propertyId,
            marketPrice = marketPrice,
            location = location?.toLocation(),
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoom() },
            annex = annex?.map { it.toAnnex() },
            services = services,
            propertyTax = propertyTax,
            media = propertyMedia,
            notes = propertyNotes,
            contacts = contacts?.map { it.toContact() },
            floor = floor,
            buildingFloors = buildingFloors,
            lift = lift,
            condominiumFees = condominiumFees
        )
        PropertyType.HOUSE -> House(
            id = propertyId,
            marketPrice = marketPrice,
            location = location?.toLocation(),
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoom() },
            annex = annex?.map { it.toAnnex() },
            services = services,
            propertyTax = propertyTax,
            media = propertyMedia,
            notes = propertyNotes,
            contacts = contacts?.map { it.toContact() },
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
            location = location?.toEntity(),
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoomEntity() },
            annex = annex?.map { it.toAnnexEntity() },
            services = services,
            propertyTax = propertyTax,
            propertyMedia = media,
            propertyNotes = notes,
            contacts = contacts?.map { it.toEntity() },
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
            location = location?.toEntity(),
            surface = surface,
            orientation = orientation,
            rooms = rooms?.map { it.toRoomEntity() },
            annex = annex?.map { it.toAnnexEntity() },
            services = services,
            propertyTax = propertyTax,
            propertyMedia = media,
            propertyNotes = notes,
            contacts = contacts?.map { it.toEntity() },
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