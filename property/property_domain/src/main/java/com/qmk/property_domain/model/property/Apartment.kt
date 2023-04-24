package com.qmk.property_domain.model.property

import com.qmk.property_domain.model.Location
import com.qmk.property_domain.model.Orientation
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.model.room.Room

data class Apartment(
    override val id: Int? = null,
    override val marketPrice: Int?,
    override val location: Location? = null,
    override val surface: Double?,
    override val orientation: Orientation? = null,
    override val rooms: List<Room>?,
    override val annex: List<Annex>? = null,
    override val services: PublicService? = null,
    override val propertyTax: Int? = null,
    override val media: List<String>? = null,
    override val notes: String? = null,
    override val contacts: List<Contact>? = null,
    val floor: Int? = null,
    val buildingFloors: Int? = null,
    val lift: Boolean? = null,
    val condominiumFees: Int? = null,
) : Property
