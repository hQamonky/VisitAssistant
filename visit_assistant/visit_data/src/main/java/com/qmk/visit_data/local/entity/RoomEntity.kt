package com.qmk.visit_data.local.entity

import androidx.room.*
import com.qmk.visit_domain.model.room.*

@Entity(foreignKeys = [ForeignKey(entity = PropertyEntity::class,
    parentColumns = arrayOf("propertyId"),
    childColumns = arrayOf("roomId"),
    onDelete = ForeignKey.CASCADE
)])
data class RoomEntity(
    @PrimaryKey var roomId: Int? = null,
    var surface: Int? = null,
    var width: Int? = null,
    var length: Int? = null,
    var roomType: RoomType? = null,
    @Ignore var openings: List<OpeningEntity>? = listOf(),
    @Embedded var walls: WallEntity? = null,
    @Embedded var ceiling: CeilingEntity? = null,
    @Embedded var flooring: FloorEntity? = null,
    var roomMedia: List<String>? = listOf(),
    var roomNotes: String? = null,
    var propertyId: Int? = null
)
