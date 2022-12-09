package test.casavo.notification

import java.util.*

data class CreateGoodNotificationCommand(
    val goodId: UUID,
    val buyerId: UUID,
)