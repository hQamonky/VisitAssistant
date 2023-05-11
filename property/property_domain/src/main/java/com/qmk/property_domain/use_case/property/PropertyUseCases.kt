package com.qmk.property_domain.use_case.property

data class PropertyUseCases(
    val getProperties: GetPropertiesUseCase,
    val insertProperty: InsertPropertyUseCase,
    val deleteProperty: DeletePropertyUseCase
)
