package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.qmk.property_domain.model.Location

data class AgencyEntity(
    @PrimaryKey var id: Int? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var email: String? = null,
    @Embedded var address: Location?
)
