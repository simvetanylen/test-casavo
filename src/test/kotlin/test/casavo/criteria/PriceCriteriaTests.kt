package test.casavo.criteria

import test.casavo.good.GoodSpecification
import kotlin.test.Test
import kotlin.test.assertEquals

class PriceCriteriaTests {

    @Test
    fun `When price is between boundaries Then return 1`() {
        val specification = GoodSpecification(
            price = 400_000.0
        )

        val criteria = PriceCriteria(
            minimumPrice = 300_000.0,
            maximumPrice = 500_000.0,
        )

        val score = criteria.score(specification)

        assertEquals(1.0, score)
    }

    @Test
    fun `When price is lower than the minimum price Then return a value between 0 and 1`() {
        val specification = GoodSpecification(
            price = 150_000.0
        )

        val criteria = PriceCriteria(
            minimumPrice = 300_000.0,
            maximumPrice = 500_000.0,
        )

        val score = criteria.score(specification)

        assertEquals(0.5, score)
    }
}