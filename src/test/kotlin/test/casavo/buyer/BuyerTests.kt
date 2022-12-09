package test.casavo.buyer

import test.casavo.buyer.Buyer
import test.casavo.criteria.PriceCriteria
import test.casavo.criteria.SurfaceCriteria
import test.casavo.criteria.TypeCriteria
import test.casavo.good.GoodSpecification
import test.casavo.good.GoodType
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class BuyerTests {

    @Test
    fun `When one of the buyers criteria is 0 Then the score is 0`() {
        val buyer = Buyer(
            id = UUID.randomUUID(),
            searchCriteria = listOf(
                TypeCriteria(
                    acceptedTypes = listOf(GoodType.APARTMENT)
                ),
                PriceCriteria(
                    minimumPrice = 300_000.0,
                    maximumPrice = 400_000.0,
                )
            )
        )

        val specification = GoodSpecification(
            price = 350_000.0,
            type = GoodType.HOUSE
        )

        val score = buyer.score(specification)

        assertEquals(0.0, score)
    }

    @Test
    fun `When some criteria have a score below 1 Then the score is the multiplication of all scores`() {
        val buyer = Buyer(
            id = UUID.randomUUID(),
            searchCriteria = listOf(
                PriceCriteria(
                    minimumPrice = 300_000.0,
                    maximumPrice = 400_000.0,
                ),
                SurfaceCriteria(
                    minimumSurface = 100,
                    maximumSurface = 200,
                )
            )
        )

        val specification = GoodSpecification(
            price = 500_000.0,
            surface = 80,
        )

        val score = buyer.score(specification)

        assertEquals(0.6400000000000001, score)
    }
}