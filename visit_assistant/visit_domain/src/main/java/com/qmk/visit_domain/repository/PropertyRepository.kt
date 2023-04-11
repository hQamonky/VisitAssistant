package com.qmk.visit_domain.repository

import com.qmk.visit_domain.model.property.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    suspend fun insertProperty(property: Property)

    suspend fun updateProperty(property: Property)

    suspend fun deleteProperty(property: Property)

    fun getProperties(): Flow<List<Property>>
}