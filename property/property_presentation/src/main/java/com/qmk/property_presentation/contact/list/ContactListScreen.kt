package com.qmk.property_presentation.contact.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_presentation.R

@Composable
fun ContactListScreen(
    modifier: Modifier = Modifier,
    viewModel: ContactListViewModel = hiltViewModel(),
    onNewContactClick: () -> Unit,
    onEditContactClick: (contact: Contact) -> Unit,
    onDeleteContactClick: (contact: Contact) -> Unit
) {
    val contacts = viewModel.contacts
    LazyColumn(modifier = modifier) {
        item {
            IconButton(onClick = { onNewContactClick() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.new_contact)
                )
            }
        }
        items(contacts) { contact ->
            ContactListItem(
                modifier = Modifier.fillMaxWidth(),
                contact = contact,
                onEditClick = onEditContactClick,
                onDeleteClick = onDeleteContactClick
            )
            Divider()
        }
    }
}