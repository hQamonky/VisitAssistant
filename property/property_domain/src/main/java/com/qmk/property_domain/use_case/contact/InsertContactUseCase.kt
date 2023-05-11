package com.qmk.property_domain.use_case.contact

import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.repository.PropertyRepository

class InsertContactUseCase(
    private val repository: PropertyRepository
) {
    suspend operator fun invoke(contact: Contact) {
        repository.insertContact(contact)
    }
}