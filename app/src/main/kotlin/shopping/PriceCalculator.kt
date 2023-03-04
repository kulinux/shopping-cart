package shopping

import shopping.model.Money

class PriceCalculator {
    private var accumulated: Money = Money.Zero

    fun sum(price: Money) {
        accumulated += price
    }

    fun applyDiscount(discount: Double) {
        accumulated -= accumulated.percentage(discount)
    }

    fun total(): Money = accumulated
}