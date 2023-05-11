package com.qmk.property_data.local

import androidx.room.*
import com.qmk.property_data.local.entity.AgencyEntity
import com.qmk.property_data.local.entity.ContactEntity
import com.qmk.property_data.local.entity.NeighborhoodEntity
import com.qmk.property_data.local.entity.PropertyEntity
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

    @Query(
        """
            SELECT *
            FROM contactentity
        """
    )
    fun getContacts(): Flow<List<ContactEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contactEntity: ContactEntity)

    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)

    @Query(
        """
            SELECT *
            FROM neighborhoodentity
        """
    )
    fun getNeighborhoods(): Flow<List<NeighborhoodEntity>>

    @Query(
        """
            SELECT *
            FROM agencyentity
        """
    )
    fun getAgencies(): Flow<List<AgencyEntity>>
}