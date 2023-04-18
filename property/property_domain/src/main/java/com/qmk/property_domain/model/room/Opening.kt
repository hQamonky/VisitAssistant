package com.qmk.property_domain.model.room

data class Opening(
    val openingType: OpeningType?,
    val orientation: com.qmk.property_domain.model.Orientation?,
    val vue: VueType?,
    val openingCondition: com.qmk.property_domain.model.Condition?,
    val frameCondition: com.qmk.property_domain.model.Condition?,
    val lockerAndHandleCondition: com.qmk.property_domain.model.Condition?,
    val shutters: Shutter?,
    val media: List<String>?,
    val notes: String?
)

data class Shutter(
    val type: ShutterType?,
    val condition: com.qmk.property_domain.model.Condition?
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