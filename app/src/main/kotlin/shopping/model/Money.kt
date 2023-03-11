package shopping.model

import arrow.core.andThen
import arrow.core.identity
import arrow.typeclasses.Monoid

data class Money(val value: Double) {
    operator fun plus(money: Money): Money = Money(value + money.value)

    fun percentage(d: Double): Money =
        Money(value * d / 100)

    operator fun minus(money: Money): Money = Money(value - money.value)

    companion object {
        val Zero = Money(0.0)

        val FunctionMonoid: Monoid<(Money) -> Money> = object : Monoid<(Money) -> Money> {
            override fun empty(): (Money) -> Money = ::identity
            override fun ((Money) -> Money).combine(b: (Money) -> Money): (Money) -> Money = this andThen b
        }
    }
}

