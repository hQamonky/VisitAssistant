package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.AgencyEntity
import com.qmk.property_domain.model.contact.Agency

fun AgencyEntity.toAgency(): Agency {
    return Agency(
        id = agencyId,
        name = agencyName,
        phoneNumber = agencyPhoneNumber,
        email = agencyEmail,
        address = agencyAddress?.toLocation()
    )
}

fun Agency.toEntity(): AgencyEntity {
    return AgencyEntity(
        agencyId = id,
        agencyName = name,
        agencyPhoneNumber = phoneNumber,
        agencyEmail = email,
        agencyAddress = address?.toEntity()
    )
}