package test.casavo.criteria

import test.casavo.good.GoodSpecification

data class PriceCriteria(
    private val minimumPrice: Double,
    private val maximumPrice: Double,
): SearchCriteria {

    override fun score(specification: GoodSpecification): Double {
        if (specification.price in minimumPrice..maximumPrice) {
            return 1.0
        }

        if (specification.price < minimumPrice) {
            return specification.price / minimumPrice
        }

        return maximumPrice / specification.price
    }
}