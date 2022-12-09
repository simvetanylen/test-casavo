package test.casavo.notification

interface CommandProducer {
    fun produce(command: Any)
}