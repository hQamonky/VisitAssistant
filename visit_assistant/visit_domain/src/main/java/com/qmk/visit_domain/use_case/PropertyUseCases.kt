package com.qmk.visit_domain.use_case

data class PropertyUseCases(
    val getProperties: GetProperties,
    val createProperty: CreateProperty,
    val updateProperty: UpdateProperty,
    val deleteProperty: DeleteProperty
)
