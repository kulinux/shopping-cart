package shopping

data class Money(val value: Double) {
    companion object {
        val NoPrice = Money(1000000.0)
    }
}
