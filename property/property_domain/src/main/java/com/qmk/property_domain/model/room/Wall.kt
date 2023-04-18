package com.qmk.property_domain.model.room

import com.qmk.property_domain.model.Condition

data class Wall(
    val condition: Condition?,
    val media: List<String>?,
    val notes: String?
)
