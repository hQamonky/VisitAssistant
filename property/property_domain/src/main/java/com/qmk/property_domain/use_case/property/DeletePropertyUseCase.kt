package com.qmk.property_domain.use_case.property

import com.qmk.property_domain.model.property.Property
import com.qmk.property_domain.repository.PropertyRepository

class DeletePropertyUseCase(
    private val repository: PropertyRepository
) {
    suspend operator fun invoke(property: Property) {
        repository.deleteProperty(property)
    }
}