package com.qmk.property_data.di

import android.app.Application
import androidx.room.Room
import com.qmk.property_data.local.PropertyDatabase
import com.qmk.property_data.repository.PropertyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VisitDataModule {

    @Provides
    @Singleton
    fun providePropertyDatabase(app: Application): PropertyDatabase {
        return Room.databaseBuilder(
            app,
            PropertyDatabase::class.java,
            "property_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePropertyRepository(
        db: PropertyDatabase
    ): com.qmk.property_domain.repository.PropertyRepository {
        return PropertyRepositoryImpl(db.dao)
    }
}