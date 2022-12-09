package test.casavo.good

import test.casavo.common.Address

data class GoodSpecification(
    val description: String = "",
    val surface: Int = 0,
    val fieldSurface: Int? = null,
    val floor: Int? = null,
    val numberOfFloors: Int = 1,
    val numberOfRooms: Int = 1,
    val type: GoodType = GoodType.APARTMENT,
    val address: Address = Address(),
    val price: Double = -1.0,
)