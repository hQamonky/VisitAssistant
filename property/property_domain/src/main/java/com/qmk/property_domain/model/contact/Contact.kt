package com.qmk.property_domain.model.contact

data class Contact(
    val id: Int? = null,
    val firstName: String? = "",
    val lastName: String? = "",
    val gender: Gender? = Gender.MALE,
    val email: String? = "",
    val phoneNumber: String? = "",
    val agency: Agency? = Agency()
)

enum class Gender {
    MALE,
    FEMALE,
    UNDEFINED
}