package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.qmk.property_domain.model.contact.Gender

@Entity(foreignKeys = [ForeignKey(entity = PropertyEntity::class,
    parentColumns = arrayOf("propertyId"),
    childColumns = arrayOf("contactId"),
    onDelete = ForeignKey.CASCADE
)])
data class ContactEntity(
    @PrimaryKey var contactId: Int? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var gender: Gender? = null,
    var email: String? = null,
    var phoneNumber: String? = null,
    @Embedded var agency: AgencyEntity? = null
)
