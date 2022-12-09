package test.casavo.common

data class Address(
    val streetName: String = "",
    val streetNumber: String = "",
    val city: String = "",
    val postalCode: String = "",
    val country: String = "",
    val coordinates: Coordinates = Coordinates(),
)