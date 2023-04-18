package com.qmk.visit_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qmk.visit_domain.model.Condition
import com.qmk.visit_domain.model.room.ShutterType

@Entity
data class ShutterEntity(
    @PrimaryKey var shutterId: Int? = null,
    var shutterType: ShutterType? = null,
    var shutterCondition: Condition? = null
    
)
