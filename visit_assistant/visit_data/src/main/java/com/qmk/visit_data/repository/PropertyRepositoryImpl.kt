package com.qmk.visit_data.repository

import com.qmk.visit_data.local.PropertyDao
import com.qmk.visit_data.mapper.toEntity
import com.qmk.visit_data.mapper.toProperty
import com.qmk.visit_domain.model.property.Property
import com.qmk.visit_domain.repository.PropertyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

class PropertyRepositoryImpl(private val dao: PropertyDao): PropertyRepository {
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