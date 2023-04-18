package com.qmk.property_data.repository

import com.qmk.property_data.local.PropertyDao
import com.qmk.property_data.mapper.toEntity
import com.qmk.property_data.mapper.toProperty
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
}