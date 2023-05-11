package com.qmk.property_domain.repository

import com.qmk.property_domain.model.Neighborhood
import com.qmk.property_domain.model.contact.Agency
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.model.property.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    suspend fun insertProperty(property: Property)

    suspend fun deleteProperty(property: Property)

    fun getProperties(): Flow<List<Property>>

    fun getContacts(): Flow<List<Contact>>

    suspend fun insertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)

    fun getNeighborhoods(): Flow<List<Neighborhood>>

    fun getAgencies(): Flow<List<Agency>>
}