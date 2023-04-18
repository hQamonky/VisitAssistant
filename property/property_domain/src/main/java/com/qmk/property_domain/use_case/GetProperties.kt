package com.qmk.property_domain.use_case

import com.qmk.property_domain.model.property.Property
import com.qmk.property_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow

class GetProperties(
    private val repository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Property>> {
        return repository.getProperties()
    }
}