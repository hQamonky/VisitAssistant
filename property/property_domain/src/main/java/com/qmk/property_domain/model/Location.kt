package com.qmk.property_domain.model

data class Location(
    val id: Int? = null,
    val streetNumber: Int? = null,
    val streetName: String? = "",
    val neighborhood: Neighborhood? = Neighborhood(),
    val postalCode: String? = "",
    val city: String? = "",
    val country: String? = "",
    val latitude: Double? = null,
    val longitude: Double? = null
)
