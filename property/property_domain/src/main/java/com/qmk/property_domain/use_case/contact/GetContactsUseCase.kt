package com.qmk.property_domain.use_case.contact

import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow

class GetContactsUseCase(
    private val repository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Contact>> {
        return repository.getContacts()
    }
}