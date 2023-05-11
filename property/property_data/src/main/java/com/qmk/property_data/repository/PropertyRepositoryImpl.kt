package com.qmk.property_data.repository

import com.qmk.property_data.local.PropertyDao
import com.qmk.property_data.mapper.*
import com.qmk.property_domain.model.Neighborhood
import com.qmk.property_domain.model.contact.Agency
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.model.property.Property
import com.qmk.property_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.*

class PropertyRepositoryImpl(private val dao: PropertyDao):
    PropertyRepository {
    override suspend fun insertProperty(property: Property) {
        val propertyEntity = property.toEntity()
        dao.insertProperty(propertyEntity)
    }

    override suspend fun deleteProperty(property: Property) {
        dao.deleteProperty(property.toEntity())
    }

    override fun getProperties(): Flow<List<Property>> {
        return dao.getProperties().map { entities ->
            entities.mapNotNull { entity -> entity.toProperty() }
        }
    }

    override fun getContacts(): Flow<List<Contact>> {
        return dao.getContacts().map { entities ->
            entities.map { entity -> entity.toContact() }
        }
    }

    override suspend fun insertContact(contact: Contact) {
        dao.insertContact(contact.toEntity())
    }

    override suspend fun deleteContact(contact: Contact) {
        dao.deleteContact(contact.toEntity())
    }

    override fun getNeighborhoods(): Flow<List<Neighborhood>> {
        return dao.getNeighborhoods().map { entities ->
            entities.map { entity -> entity.toNeighborhood() }
        }
    }

    override fun getAgencies(): Flow<List<Agency>> {
        return dao.getAgencies().map { entities ->
            entities.map { entity -> entity.toAgency() }
        }
    }
}