package com.qmk.property_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.qmk.property_data.local.entity.*

@Database(
    entities = [
        PropertyEntity::class,
        LocationEntity::class,
        NeighborhoodEntity::class,
        RoomEntity::class,
        AnnexEntity::class,
        OpeningEntity::class,
               ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PropertyDatabase: RoomDatabase() {
    abstract val dao: PropertyDao
}