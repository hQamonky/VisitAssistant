package com.qmk.property_domain.model.room

data class Room(
    val surface: Int? = null,
    val width: Int? = null,
    val length: Int? = null,
    val type: RoomType? = null,
    val openings: List<Opening>? = null,
    val walls: Wall? = null,
    val ceiling: Ceiling? = null,
    val floor: Floor? = null,
    val media: List<String>? = null,
    val notes: String? = null
)

enum class RoomType{
    KITCHEN,
    LIVING_ROOM,
    TOILET,
    BATHROOM,
    BEDROOM,
    DRESSING,
    LAUNDRY
}
