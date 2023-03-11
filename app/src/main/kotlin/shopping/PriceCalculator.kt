package shopping

import arrow.core.andThen
import arrow.core.fold
import arrow.core.identity
import shopping.model.Money

class PriceCalculator {

    fun price(products: List<Money>, discount: Double?): Money {
        val sum = products.map { this.sum(it) }.fold(Money.FunctionMonoid)
        val applyDiscount = this.applyDiscount(discount)

        val total = sum andThen applyDiscount

        return total(Money.Zero)
    }

    private fun sum(price: Money): (Money) -> (Money) = { it + price }

    private fun applyDiscount(discount: Double?): (Money) -> Money {
        when (discount) {
            null -> return ::identity
            else -> return {it - it.percentage(discount)}
        }
    }

}