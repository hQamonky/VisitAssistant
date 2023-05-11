package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = ContactEntity::class,
    parentColumns = arrayOf("contactId"),
    childColumns = arrayOf("agencyId"),
    onDelete = ForeignKey.CASCADE
)])
data class AgencyEntity(
    @PrimaryKey var agencyId: Int? = null,
    var agencyName: String? = null,
    var agencyPhoneNumber: String? = null,
    var agencyEmail: String? = null,
    @Embedded var agencyAddress: LocationEntity?
)
