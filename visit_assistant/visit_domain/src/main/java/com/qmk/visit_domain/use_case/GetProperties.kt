package com.qmk.visit_domain.use_case

import com.qmk.visit_domain.model.property.Property
import com.qmk.visit_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow

class GetProperties(
    private val repository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Property>> {
        return repository.getProperties()
    }
}