package test.casavo.buyer

import test.casavo.good.GoodSpecification
import test.casavo.criteria.SearchCriteria
import java.util.*

data class Buyer(
    val id: UUID,
    val searchCriteria: List<SearchCriteria>
) {

    fun score(specification: GoodSpecification): Double {
        var score = 1.0

        searchCriteria.forEach {
            score *= it.score(specification)
        }

        return score
    }
}