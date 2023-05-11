package com.qmk.property_presentation.contact.entry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.qmk.property_domain.model.Location
import com.qmk.property_domain.model.contact.Agency
import com.qmk.property_domain.model.contact.Contact
import com.qmk.property_domain.model.contact.Gender
import com.qmk.property_presentation.R

@Composable
fun ContactEntryScreen(
    modifier: Modifier = Modifier,
    viewModel: ContactEntryViewModel = hiltViewModel(),
    initialContact: Contact = Contact(),
    saveButtonText: String,
    onSaveClick: (contact: Contact) -> Unit
) {
    // TODO : Fix compilation error (due to remember not used properly ?)
    var contact by remember { mutableStateOf(initialContact) }

    var newAgency by remember { mutableStateOf(false) }
    val agencies = viewModel.agencies
    var isAgenciesExpanded by remember {
        mutableStateOf(false)
    }
    val agenciesDisabledItem = 0

    var isGenderExpanded by remember {
        mutableStateOf(false)
    }
    val genderDisabledItem = 0

    val neighborhoods = viewModel.neighborhoods
    var isNeighborhoodsExpanded by remember {
        mutableStateOf(false)
    }
    val neighborhoodsDisabledItem = 0

    Column(
        modifier = modifier
    ) {
        Text(text = stringResource(R.string.contact))
        OutlinedTextField(
            label = { Text(text = stringResource(R.string.first_name)) },
            value = contact.firstName ?: "",
            onValueChange = { contact = contact.copy(firstName = it) }
        )
        OutlinedTextField(
            label = { Text(text = stringResource(R.string.last_name)) },
            value = contact.lastName ?: "",
            onValueChange = { contact = contact.copy(lastName = it) }
        )
        DropdownMenu(
            expanded = isGenderExpanded,
            onDismissRequest = {
                isGenderExpanded = false
            }
        ) {
            Gender.values().forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    text = {
                           Text(text = itemValue.name)
                    },
                    onClick = {
                        contact = contact.copy(gender = itemValue)
                        isGenderExpanded = false
                    },
                    enabled = (itemIndex != genderDisabledItem)
                )
            }
        }
        OutlinedTextField(
            label = { Text(text = stringResource(R.string.email)) },
            value = contact.email ?: "",
            onValueChange = { contact = contact.copy(email = it) },
            placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            label = { Text(text = stringResource(R.string.phone_number)) },
            value = contact.phoneNumber ?: "",
            onValueChange = { contact = contact.copy(phoneNumber = it) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Text(text = stringResource(R.string.agency))
        if (newAgency) {
            Button(onClick = {
                newAgency = false
            }) {
                Text(text = stringResource(R.string.cancel))
            }
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.name)) },
                value = contact.agency?.name ?: "",
                onValueChange = {
                    contact = contact.copy(agency = contact.agency?.copy(name = it) ?: Agency(name = it))
                }
            )
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.phone_number)) },
                value = contact.agency?.phoneNumber ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(phoneNumber = it) ?: Agency(phoneNumber = it)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.email)) },
                value = contact.agency?.email ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(email = it) ?: Agency(email = it)
                    )
                },
                placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )
            Text(text = stringResource(R.string.address))
            // TODO : Use api and repository to get countries, cities, neighborhoods and streets, to filter out as the user enters fields
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.street_number)) },
                value = contact.agency?.address?.streetNumber.toString(),
                onValueChange = {
                    val streetNumber = it.toInt()
                    contact = contact.copy(
                        agency = contact.agency?.copy(
                            address = contact.agency?.address?.copy(
                                streetNumber = streetNumber
                            ) ?: Location(streetNumber = streetNumber)
                        ) ?: Agency(address = Location(streetNumber = streetNumber))
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.street_name)) },
                value = contact.agency?.address?.streetName ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(
                            address = contact.agency?.address?.copy(
                                streetName = it
                            ) ?: Location(streetName = it)
                        ) ?: Agency(address = Location(streetName = it))
                    )
                }
            )
            DropdownMenu(
                expanded = isNeighborhoodsExpanded,
                onDismissRequest = {
                    isNeighborhoodsExpanded = false
                }
            ) {
                neighborhoods.forEachIndexed { itemIndex, itemValue ->
                    DropdownMenuItem(
                        text = {
                            itemValue.name?.let { Text(text = it) }
                        },
                        onClick = {
                            contact = contact.copy(
                                agency = contact.agency?.copy(
                                    address = contact.agency?.address?.copy(
                                        neighborhood = itemValue
                                    ) ?: Location(neighborhood = itemValue)
                                ) ?: Agency(address = Location(neighborhood = itemValue))
                            )
                            isNeighborhoodsExpanded = false
                        },
                        enabled = (itemIndex != neighborhoodsDisabledItem)
                    )
                }
            }
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.postal_code)) },
                value = contact.agency?.address?.postalCode ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(
                            address = contact.agency?.address?.copy(
                                postalCode = it
                            ) ?: Location(postalCode = it)
                        ) ?: Agency(address = Location(postalCode = it))
                    )
                }
            )
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.city)) },
                value = contact.agency?.address?.city ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(
                            address = contact.agency?.address?.copy(
                                city = it
                            ) ?: Location(city = it)
                        ) ?: Agency(address = Location(city = it))
                    )
                }
            )
            OutlinedTextField(
                label = { Text(text = stringResource(R.string.country)) },
                value = contact.agency?.address?.country ?: "",
                onValueChange = {
                    contact = contact.copy(
                        agency = contact.agency?.copy(
                            address = contact.agency?.address?.copy(
                                country = it
                            ) ?: Location(country = it)
                        ) ?: Agency(address = Location(country = it))
                    )
                }
            )
        } else {
            Button(onClick = {
                newAgency = true
            }) {
                Text(text = stringResource(R.string.new_agency))
            }
            DropdownMenu(
                expanded = isAgenciesExpanded,
                onDismissRequest = {
                    isAgenciesExpanded = false
                }
            ) {
                agencies.forEachIndexed { itemIndex, itemValue ->
                    DropdownMenuItem(
                        text = {
                            itemValue.name?.let { Text(text = it) }
                        },
                        onClick = {
                            contact = contact.copy(agency = itemValue)
                            isAgenciesExpanded = false
                        },
                        enabled = (itemIndex != agenciesDisabledItem)
                    )
                }
            }
        }
        Button(onClick = {
            onSaveClick(contact)
        }) {
            Text(text = saveButtonText)
        }
    }
}