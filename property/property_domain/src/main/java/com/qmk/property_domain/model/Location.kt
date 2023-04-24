package com.qmk.property_domain.model

data class Location(
    val id: Int? = null,
    val streetNumber: Int?,
    val streetName: String?,
    val neighborhood: Neighborhood?,
    val postalCode: String?,
    val city: String?,
    val country: String?,
    val latitude: Double?,
    val longitude: Double?
)
