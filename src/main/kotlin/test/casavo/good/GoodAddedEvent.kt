package test.casavo.good

import test.casavo.good.GoodSpecification
import java.util.*

data class GoodAddedEvent(
    val goodId: UUID,
    val goodSpecification: GoodSpecification,
)