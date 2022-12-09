package test.casavo.criteria

import test.casavo.common.Address
import test.casavo.common.Coordinates
import test.casavo.good.GoodSpecification
import test.casavo.common.RectArea
import kotlin.test.Test
import kotlin.test.assertEquals

class AreaCriteriaTests {

    @Test
    fun `When coordinates are in the area Then return 1`() {
        val specification = GoodSpecification(
            address = Address(
                coordinates = Coordinates(
                    latitude = 20.0,
                    longitude = 20.0,
                )
            )
        )

        val criteria = AreaCriteria(
            areas = listOf(
                RectArea(
                vector0 = Coordinates(
                    latitude = 15.0,
                    longitude = 15.0,
                ),
                vector1 = Coordinates(
                    latitude = 30.0,
                    longitude = 40.0,
                )
            )
            )
        )

        val score = criteria.score(specification)

        assertEquals(1.0, score)
    }

    @Test
    fun `When coordinates are not in the area Then return 0`() {
        val specification = GoodSpecification(
            address = Address(
                coordinates = Coordinates(
                    latitude = 10.0,
                    longitude = 20.0,
                )
            )
        )

        val criteria = AreaCriteria(
            areas = listOf(
                RectArea(
                vector0 = Coordinates(
                    latitude = 15.0,
                    longitude = 15.0,
                ),
                vector1 = Coordinates(
                    latitude = 30.0,
                    longitude = 40.0,
                )
            )
            )
        )

        val score = criteria.score(specification)

        assertEquals(0.0, score)
    }
}