package test.casavo.criteria

import test.casavo.common.RectArea
import test.casavo.good.GoodSpecification

data class AreaCriteria(
    val areas: List<RectArea>
): SearchCriteria {

    override fun score(specification: GoodSpecification): Double {
        if (areas.none { it.contains(specification.address.coordinates) }) {
            return 0.0
        }

        return 1.0
    }
}