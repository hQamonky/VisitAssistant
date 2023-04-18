package com.qmk.property_domain.use_case

data class PropertyUseCases(
    val getProperties: GetProperties,
    val insertProperty: InsertProperty,
    val deleteProperty: DeleteProperty
)
