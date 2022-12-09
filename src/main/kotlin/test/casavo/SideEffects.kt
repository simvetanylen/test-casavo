package test.casavo

import test.casavo.buyer.BuyerService
import test.casavo.notification.CreateGoodNotificationCommand
import test.casavo.good.GoodAddedEvent
import test.casavo.notification.CommandProducer

class SideEffects(
    private val buyerService: BuyerService,
    private val commandProducer: CommandProducer,
) {

    fun handle(event: GoodAddedEvent) {
        buyerService.findBuyers(event.goodSpecification, minimumScore = 0.9).forEach { buyer ->
            commandProducer.produce(
                CreateGoodNotificationCommand(
                    buyerId = buyer.id,
                    goodId = event.goodId,
                )
            )
        }
    }
}