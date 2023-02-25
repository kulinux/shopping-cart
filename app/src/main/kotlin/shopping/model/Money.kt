package shopping.model

import arrow.typeclasses.Semigroup

data class Money(val value: Double) {
    operator fun plus(money: Money): Money {
        return Money(value + money.value)
    }

    companion object {
        val Zero = Money(0.0)
        val NoPrice = Money(1000000.0)
    }
}

