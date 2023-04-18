package com.qmk.visit_domain.model.room

import com.qmk.visit_domain.model.Condition

data class Ceiling(
    val type: CeilingType?,
    val condition: Condition?,
    val maxCeilingHeight: Int?,
    val minCeilingHeight: Int?,
    val media: List<String>?,
    val notes: String?
)

enum class CeilingType {
    STANDARD,
    BEAM
}
