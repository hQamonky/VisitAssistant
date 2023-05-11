package com.qmk.property_domain.di

import com.qmk.property_domain.repository.PropertyRepository
import com.qmk.property_domain.use_case.*
import com.qmk.property_domain.use_case.contact.DeleteContactUseCase
import com.qmk.property_domain.use_case.contact.GetContactsUseCase
import com.qmk.property_domain.use_case.contact.InsertContactUseCase
import com.qmk.property_domain.use_case.property.DeletePropertyUseCase
import com.qmk.property_domain.use_case.property.GetPropertiesUseCase
import com.qmk.property_domain.use_case.property.InsertPropertyUseCase
import com.qmk.property_domain.use_case.property.PropertyUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PropertyDomainModule {
    // TODO : Implement providing repository and other use cases
    @ViewModelScoped
    @Provides
    fun provideGetContactsUseCase(
        repository: PropertyRepository
    ): GetContactsUseCase {
        return GetContactsUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideInsertContactUseCase(
        repository: PropertyRepository
    ): InsertContactUseCase {
        return InsertContactUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideDeleteContactUseCase(
        repository: PropertyRepository
    ): DeleteContactUseCase {
        return DeleteContactUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetPropertiesUseCase(
        repository: PropertyRepository
    ): GetPropertiesUseCase {
        return GetPropertiesUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideInsertPropertiesUseCase(
        repository: PropertyRepository
    ): InsertPropertyUseCase {
        return InsertPropertyUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideDeletePropertyUseCase(
        repository: PropertyRepository
    ): DeletePropertyUseCase {
        return DeletePropertyUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun providePropertyUseCases(
        repository: PropertyRepository
    ): PropertyUseCases {
        return PropertyUseCases(
            getProperties = GetPropertiesUseCase(repository),
            insertProperty = InsertPropertyUseCase(repository),
            deleteProperty = DeletePropertyUseCase(repository)
        )
    }
}