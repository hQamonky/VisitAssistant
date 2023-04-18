package com.qmk.property_domain.model.property

import com.qmk.property_domain.model.Location
import com.qmk.property_domain.model.Orientation
import com.qmk.property_domain.model.room.Room

interface Property {
    val id: Int?
    val marketPrice: Int?
    val location: Location?
    val surface: Double?
    val orientation: Orientation?
    val rooms: List<Room>?
    val annex: List<Annex>?
    val services: PublicService?
    val propertyTax: Int?
    val media: List<String>?
    val notes: String?
}