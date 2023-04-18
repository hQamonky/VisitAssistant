package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmk.visit_domain.model.Condition
import com.qmk.visit_domain.model.room.CeilingType

@Entity
data class CeilingEntity(
    @PrimaryKey var ceilingId: Int? = null,
    var ceilingType: CeilingType? = null,
    var ceilingCondition: Condition? = null,
    var maxCeilingHeight: Int? = null,
    var minCeilingHeight: Int? = null,
    var ceilingMedia: List<String>? = listOf(),
    var ceilingNotes: String? = null

)
