package com.qmk.visit_data.mapper

import com.qmk.visit_data.local.entity.*
import com.qmk.visit_domain.model.room.*

fun RoomEntity.toRoom(): Room {
    return Room(
        surface = surface,
        width = width,
        length = length,
        type = roomType,
        openings = openings?.map { it.toOpening() },
        walls = walls?.toWall(),
        ceiling = ceiling?.toCeiling(),
        floor = flooring?.toFloor(),
        media = roomMedia,
        notes = roomNotes
    )
}

fun OpeningEntity.toOpening(): Opening {
    return Opening(
        openingType = openingType,
        orientation = orientation,
        vue = vue,
        openingCondition = openingCondition,
        frameCondition = frameCondition,
        lockerAndHandleCondition = lockerAndHandleCondition,
        shutters = shutters?.toShutter(),
        media = openingMedia,
        notes = openingNotes
    )
}

fun ShutterEntity.toShutter(): Shutter {
    return Shutter(
        type = shutterType,
        condition = shutterCondition
    )
}

fun WallEntity.toWall(): Wall {
    return Wall(
        condition = wallCondition,
        media = wallMedia,
        notes = wallNotes
    )
}

fun CeilingEntity.toCeiling(): Ceiling {
    return Ceiling(
        type = ceilingType,
        condition = ceilingCondition,
        maxCeilingHeight = maxCeilingHeight,
        minCeilingHeight = minCeilingHeight,
        media = ceilingMedia,
        notes = ceilingNotes
    )
}

fun FloorEntity.toFloor(): Floor {
    return Floor(
        type = floorType,
        condition = floorCondition,
        media = flooringMedia,
        notes = flooringNotes
    )
}

fun Room.toRoomEntity(): RoomEntity {
    return RoomEntity(
        surface = surface,
        width = width,
        length = length,
        roomType = type,
        openings = openings?.map { it.toOpeningEntity() },
        walls = walls?.toWallEntity(),
        ceiling = ceiling?.toCeilingEntity(),
        flooring = floor?.toFloorEntity(),
        roomMedia = media,
        roomNotes = notes
    )
}

fun Opening.toOpeningEntity(): OpeningEntity {
    return OpeningEntity(
        openingType = openingType,
        orientation = orientation,
        vue = vue,
        openingCondition = openingCondition,
        frameCondition = frameCondition,
        lockerAndHandleCondition = lockerAndHandleCondition,
        shutters = shutters?.toShutterEntity(),
        openingMedia = media,
        openingNotes = notes
    )
}

fun Shutter.toShutterEntity(): ShutterEntity {
    return ShutterEntity(
        shutterType = type,
        shutterCondition = condition
    )
}

fun Wall.toWallEntity(): WallEntity {
    return WallEntity(
        wallCondition = condition,
        wallMedia = media,
        wallNotes = notes
    )
}

fun Ceiling.toCeilingEntity(): CeilingEntity {
    return CeilingEntity(
        ceilingType = type,
        ceilingCondition = condition,
        maxCeilingHeight = maxCeilingHeight,
        minCeilingHeight = minCeilingHeight,
        ceilingMedia = media,
        ceilingNotes = notes
    )
}

fun Floor.toFloorEntity(): FloorEntity {
    return FloorEntity(
        floorType = type,
        floorCondition = condition,
        flooringMedia = media,
        flooringNotes = notes
    )
}