package com.qmk.visit_data.local

import androidx.room.*
import com.qmk.visit_data.local.entity.PropertyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDao {
    @Query(
        """
            SELECT *
            FROM propertyentity
        """
    )
    fun getProperties(): Flow<List<PropertyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProperty(propertyEntity: PropertyEntity)

    @Delete
    suspend fun deleteProperty(propertyEntity: PropertyEntity)
}