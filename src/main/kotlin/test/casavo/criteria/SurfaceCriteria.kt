package test.casavo.criteria

import test.casavo.good.GoodSpecification

data class SurfaceCriteria(
    val minimumSurface: Int,
    val maximumSurface: Int,
): SearchCriteria {

    override fun score(specification: GoodSpecification): Double {
        if (specification.surface in minimumSurface..maximumSurface) {
            return 1.0
        }

        if (specification.surface < minimumSurface) {
            return specification.surface.toDouble() / minimumSurface.toDouble()
        }

        return maximumSurface.toDouble() / specification.surface.toDouble()
    }
}