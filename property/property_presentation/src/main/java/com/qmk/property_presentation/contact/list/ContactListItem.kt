package com.qmk.property_presentation.contact.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_presentation.R

@Composable
fun ContactListItem(
    modifier: Modifier = Modifier,
    contact: Contact,
    onEditClick: (contact: Contact) -> Unit,
    onDeleteClick: (contact: Contact) -> Unit
) {
    val name = "${contact.firstName} ${contact.lastName}"
    Row(modifier = modifier) {
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            contact.phoneNumber?.let {
                Text(text = it)
            }
            contact.email?.let {
                Text(text = it)
            }
        }
        IconButton(onClick = { onEditClick(contact) }) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = stringResource(R.string.edit_contact)
            )
        }
        IconButton(onClick = { onDeleteClick(contact) }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.delete_contact)
            )
        }
    }
}