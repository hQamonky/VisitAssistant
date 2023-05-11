package com.qmk.property_domain.use_case

import com.qmk.property_domain.model.Neighborhood
import com.qmk.property_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow

class GetNeighborhoods(
    private val repository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Neighborhood>> {
        return repository.getNeighborhoods()
    }
}