package com.qmk.visit_data.repository

import com.qmk.visit_domain.model.property.Apartment
import com.qmk.visit_domain.model.room.Room
import com.qmk.visit_domain.model.room.RoomType
import io.mockk.mockk
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PropertyRepositoryImplTest {

    private lateinit var repository: PropertyRepositoryImpl

    @Before
    fun setUp() {
        repository = PropertyRepositoryImpl(dao = mockk(relaxed = true))
    }

    @Test
    fun `Insert properties, get all properties, returns result`() = runBlocking {
        val apartment1 = Apartment(
            marketPrice = 199000,
            surface = 27.0,
            rooms = listOf(
                Room(type = RoomType.LIVING_ROOM),
                Room(type = RoomType.BEDROOM)
            ),
        )
        val apartment2 = Apartment(
            marketPrice = 185000,
            surface = 22.0,
            rooms = listOf(Room(type = RoomType.LIVING_ROOM)),
        )
        repository.insertProperty(apartment1)
        repository.insertProperty(apartment2)

        val resultFlow = repository.getProperties()
        val result = resultFlow.toList()
        val count = resultFlow.count()
        
        assert(count == 2)
    }
}