package com.qmk.property_presentation.contact.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qmk.property_presentation.R
import com.qmk.property_presentation.contact.entry.ContactEntryScreen
import com.qmk.property_presentation.contact.list.ContactListRoute.CONTACT_LIST
import com.qmk.property_presentation.contact.list.ContactListRoute.EDIT_CONTACT
import com.qmk.property_presentation.contact.list.ContactListRoute.NEW_CONTACT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListNavigation(
    viewModel: ContactListViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val openDeleteDialog = remember { mutableStateOf(false) }
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = CONTACT_LIST
    ) {
        composable(CONTACT_LIST) {
            CustomScaffold(
                modifier = Modifier.fillMaxSize(),
                title = stringResource(R.string.contacts),
                onBackClick = null
            ) {
                ContactListScreen(
                    viewModel = viewModel,
                    onNewContactClick = { navController.navigate(NEW_CONTACT) },
                    onEditContactClick = {
                        viewModel.selectContact(it)
                        navController.navigate(EDIT_CONTACT)
                    },
                    onDeleteContactClick = {
                        viewModel.selectContact(it)
                        openDeleteDialog.value = true
                    }
                )
                if (openDeleteDialog.value) {
                    AlertDialog(onDismissRequest = { openDeleteDialog.value = false }) {
                        Column {
                            Text(
                                text = stringResource(R.string.delete_contact),
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                modifier = Modifier.padding(all = 8.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = { openDeleteDialog.value = false }
                                ) {
                                    Text(text = stringResource(R.string.cancel))
                                }
                                Button(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = {
                                        viewModel.deleteSelectedContact()
                                        openDeleteDialog.value = false
                                    }
                                ) {
                                    Text(text = stringResource(R.string.delete))
                                }
                            }
                        }
                    }
                }
            }
        }
        composable(NEW_CONTACT) {
            CustomScaffold(
                modifier = Modifier.fillMaxSize(),
                title = stringResource(R.string.new_contact),
                onBackClick = { navController.navigateUp() }
            ) {
                ContactEntryScreen(saveButtonText = stringResource(R.string.save), onSaveClick = {
                    viewModel.saveContact(it)
                })
            }
        }
        composable(EDIT_CONTACT) {
            CustomScaffold(
                modifier = Modifier.fillMaxSize(),
                title = stringResource(R.string.edit_contact),
                onBackClick = { navController.navigateUp() }
            ) {
                viewModel.selectedContact?.let { contact ->
                    ContactEntryScreen(
                        initialContact = contact,
                        saveButtonText = stringResource(R.string.save),
                        onSaveClick = {
                            viewModel.saveContact(it)
                        }
                    )
                } ?: Text(text = stringResource(R.string.no_contact_error))
            }
        }
    }
}

@Composable
private fun CustomScaffold(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: (() -> Unit)?,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                title = title,
                onBackClick = onBackClick
            )
        },
        content = content
    )
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: (() -> Unit)?
) {
    Row(modifier = modifier) {
        onBackClick?.let {
            IconButton(onClick = it) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}