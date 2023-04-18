package com.qmk.property_domain.use_case

import com.qmk.property_domain.model.property.Property
import com.qmk.property_domain.repository.PropertyRepository

class InsertProperty(
    private val repository: PropertyRepository
) {
    suspend operator fun invoke(property: Property) {
        repository.insertProperty(property)
    }
}