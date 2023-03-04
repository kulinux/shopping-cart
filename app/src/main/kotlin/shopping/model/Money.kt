package shopping.model

data class Money(val value: Double) {
    operator fun plus(money: Money): Money = Money(value + money.value)

    fun percentage(d: Double): Money =
        Money(value * d / 100)

    operator fun minus(money: Money): Money = Money(value - money.value)

    companion object {
        val Zero = Money(0.0)
        val NoPrice = Money(1000000.0)
    }
}

