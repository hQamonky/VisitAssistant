package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmk.visit_domain.model.Condition
import com.qmk.visit_domain.model.room.FloorType

@Entity
data class FloorEntity(
    @PrimaryKey var floorId: Int? = null,
    var floorType: FloorType? = null,
    var floorCondition: Condition? = null,
    var flooringMedia: List<String>? = listOf(),
    var flooringNotes: String? = null

)
