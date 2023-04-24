package com.qmk.property_domain.model.contact

data class Contact(
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val gender: Gender?,
    val email: String?,
    val phoneNumber: String?,
    val agency: Agency?
)

enum class Gender {
    MALE,
    FEMALE,
    UNDEFINED
}