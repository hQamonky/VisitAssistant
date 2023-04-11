package com.qmk.visit_domain.model.property

import com.qmk.visit_domain.model.Location
import com.qmk.visit_domain.model.Orientation
import com.qmk.visit_domain.model.room.Room

data class House(
    override val id: Int?,
    override val marketPrice: Int,
    override val location: Location?,
    override val surface: Double,
    override val orientation: Orientation?,
    override val rooms: List<Room>,
    override val annex: List<Annex>,
    override val services: PublicService?,
    override val propertyTax: Int?,
    override val media: List<String>,
    override val notes: String,
    val floors: Int?,
    val landSurface: Int?
) : Property
