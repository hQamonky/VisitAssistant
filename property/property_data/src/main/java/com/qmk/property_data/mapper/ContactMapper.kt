package com.qmk.property_data.mapper

import com.qmk.property_data.local.entity.ContactEntity
import com.qmk.property_domain.model.contact.Contact

fun ContactEntity.toContact(): Contact {
    return Contact(
        id = contactId,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        email = contactEmail,
        phoneNumber = contactPhoneNumber,
        agency = agency?.toAgency()
    )
}

fun Contact.toEntity(): ContactEntity {
    return ContactEntity(
        contactId = id,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        contactEmail = email,
        contactPhoneNumber = phoneNumber,
        agency = agency?.toEntity()
    )
}