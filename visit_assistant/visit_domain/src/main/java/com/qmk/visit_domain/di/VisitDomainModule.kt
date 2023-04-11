package com.qmk.visit_domain.di

import com.qmk.visit_domain.repository.PropertyRepository
import com.qmk.visit_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object VisitDomainModule {
    @ViewModelScoped
    @Provides
    fun providePropertyRepositoryUseCases(
        repository: PropertyRepository
    ): PropertyUseCases {
        return PropertyUseCases(
            getProperties = GetProperties(repository),
            createProperty = CreateProperty(repository),
            updateProperty = UpdateProperty(repository),
            deleteProperty = DeleteProperty(repository)
        )
    }
}