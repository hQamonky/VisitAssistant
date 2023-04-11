package com.qmk.visit_domain.model.room

import com.qmk.visit_domain.model.Condition

data class Floor(
    val type: FloorType,
    val condition: Condition,
    val media: List<String>,
    val notes: String
)

enum class FloorType {
    TILES,
    PARQUET,
    STONE
}