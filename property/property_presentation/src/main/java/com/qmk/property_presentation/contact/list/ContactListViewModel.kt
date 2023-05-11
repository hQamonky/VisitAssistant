package com.qmk.property_presentation.contact.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.use_case.contact.DeleteContactUseCase
import com.qmk.property_domain.use_case.contact.GetContactsUseCase
import com.qmk.property_domain.use_case.contact.InsertContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactListViewModel @Inject constructor(
    getContacts: GetContactsUseCase,
    private val insertContact: InsertContactUseCase,
    private val deleteContact: DeleteContactUseCase
) : ViewModel() {
    var contacts by mutableStateOf(mutableListOf<Contact>())
        private set
    var selectedContact: Contact? = null
        private set

    init {
        viewModelScope.launch {
            getContacts().collect {
                contacts = it.toMutableList()
            }
        }
    }

    fun selectContact(contact: Contact?) {
        selectedContact = contact
    }

    fun saveContact(contact: Contact) {
        viewModelScope.launch {
            insertContact(contact)
        }
    }

    fun deleteSelectedContact() {
        selectedContact?.let {
            viewModelScope.launch {
                deleteContact(it)
                selectedContact = null
            }
        }
    }
}