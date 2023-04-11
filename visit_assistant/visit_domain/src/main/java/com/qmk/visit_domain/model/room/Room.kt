package com.qmk.visit_domain.model.room

data class Room(
    val surface: Int?,
    val width: Int?,
    val length: Int?,
    val type: RoomType,
    val openings: List<Opening>?,
    val walls: Wall?,
    val ceiling: Ceiling?,
    val floor: Floor?,
    val media: List<String>,
    val notes: String
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
