package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmk.visit_domain.model.Condition

@Entity
data class WallEntity(
    @PrimaryKey var wallId: Int? = null,
    var wallCondition: Condition? = null,
    var wallMedia: List<String>? = listOf(),
    var wallNotes: String? = null
)