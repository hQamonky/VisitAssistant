package com.qmk.visit_domain.use_case

import com.qmk.visit_domain.model.property.Property
import com.qmk.visit_domain.repository.PropertyRepository

class CreateProperty(
    private val repository: PropertyRepository
) {
    suspend operator fun invoke(property: Property) {
        repository.insertProperty(property)
    }
}