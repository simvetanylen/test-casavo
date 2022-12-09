package test.casavo.criteria

import test.casavo.good.GoodSpecification
import test.casavo.good.GoodType

data class TypeCriteria(
    val acceptedTypes: List<GoodType>,
): SearchCriteria {

    override fun score(specification: GoodSpecification): Double {
        return if (specification.type in acceptedTypes) {
            1.0
        } else {
            0.0
        }
    }
}