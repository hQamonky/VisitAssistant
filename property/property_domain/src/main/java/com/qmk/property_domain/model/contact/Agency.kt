package com.qmk.property_domain.model.contact

import com.qmk.property_domain.model.Location

data class Agency(
    val id: Int? = null,
    val name: String? = "",
    val phoneNumber: String? = "",
    val email: String? = "",
    val address: Location? = Location()
)
