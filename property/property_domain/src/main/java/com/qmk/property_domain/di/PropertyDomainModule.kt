package com.qmk.property_domain.di

import com.qmk.property_domain.repository.PropertyRepository
import com.qmk.property_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PropertyDomainModule {
    @ViewModelScoped
    @Provides
    fun providePropertyRepositoryUseCases(
        repository: PropertyRepository
    ): PropertyUseCases {
        return PropertyUseCases(
            getProperties = GetProperties(repository),
            insertProperty = InsertProperty(repository),
            deleteProperty = DeleteProperty(repository)
        )
    }
}