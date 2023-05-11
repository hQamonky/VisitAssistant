package com.qmk.property_domain.use_case

import com.qmk.property_domain.model.contact.Agency
import com.qmk.property_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow

class GetAgencies(
    private val repository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Agency>> {
        return repository.getAgencies()
    }
}