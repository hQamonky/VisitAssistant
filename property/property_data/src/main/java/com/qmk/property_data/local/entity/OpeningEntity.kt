package com.qmk.property_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.qmk.property_domain.model.Condition
import com.qmk.property_domain.model.Orientation
import com.qmk.property_domain.model.room.OpeningType
import com.qmk.property_domain.model.room.VueType

@Entity(foreignKeys = [ForeignKey(entity = RoomEntity::class,
    parentColumns = arrayOf("roomId"),
    childColumns = arrayOf("openingId"),
    onDelete = ForeignKey.CASCADE
)])
data class OpeningEntity(
    @PrimaryKey var openingId: Int? = null,
    var openingType: OpeningType? = null,
    var orientation: Orientation? = null,
    var vue: VueType? = null,
    var openingCondition: Condition? = null,
    var frameCondition: Condition? = null,
    var lockerAndHandleCondition: Condition? = null,
    @Embedded var shutters: ShutterEntity? = null,
    var openingMedia: List<String>? = listOf(),
    var openingNotes: String? = null,
    var roomId: Int? = null
)
