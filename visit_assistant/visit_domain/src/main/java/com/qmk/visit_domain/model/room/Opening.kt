package com.qmk.visit_domain.model.room

import com.qmk.visit_domain.model.Condition
import com.qmk.visit_domain.model.Orientation

data class Opening(
    val openingType: OpeningType?,
    val orientation: Orientation?,
    val vue: VueType?,
    val openingCondition: Condition?,
    val frameCondition: Condition?,
    val lockerAndHandleCondition: Condition?,
    val shutters: Shutter?,
    val media: List<String>?,
    val notes: String?
)

data class Shutter(
    val type: ShutterType?,
    val condition: Condition?
)

enum class ShutterType {
    BASIC,
    MOTORIZED
}

enum class OpeningType{
    WINDOW,
    SKYLIGHT,
    FRENCH_WINDOW,
    DOOR
}

enum class VueType {
    BUILDING,
    STREET,
    NATURE,
    SEA
}