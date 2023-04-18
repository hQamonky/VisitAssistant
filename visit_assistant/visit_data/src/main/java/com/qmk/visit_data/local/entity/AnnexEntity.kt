package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.qmk.visit_domain.model.property.AnnexType

@Entity(foreignKeys = [ForeignKey(entity = PropertyEntity::class,
    parentColumns = arrayOf("propertyId"),
    childColumns = arrayOf("annexId"),
    onDelete = ForeignKey.CASCADE
)])
data class AnnexEntity(
    @PrimaryKey var annexId: Int? = null,
    var surface: Int? = null,
    var annexType: AnnexType? = null,
    var propertyId: Int? = null
)
