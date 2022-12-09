package test.casavo.criteria

import test.casavo.good.GoodSpecification

interface SearchCriteria {
    fun score(specification: GoodSpecification): Double
}