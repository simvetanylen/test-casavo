package test.casavo.buyer

import test.casavo.good.GoodSpecification

class BuyerService {

    private val buyers = mutableListOf<Buyer>()

    fun add(buyer: Buyer) {
        buyers += buyer
    }

    fun findBuyers(goodSpecification: GoodSpecification, minimumScore: Double): List<Buyer> {
        return buyers.filter { buyer ->
            buyer.score(goodSpecification) >= minimumScore
        }
    }
}