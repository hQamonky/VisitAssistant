package com.qmk.property_domain.model.property

data class Annex(
    val surface: Int?,
    val type: AnnexType?
)

enum class AnnexType {
    BOX,
    PARKING,
    GARAGE,
    BALCONY,
    TERRACE,
    CELLAR,
    ATTIC,
    POOL,
    SPA,
    TENNIS_COURT
}