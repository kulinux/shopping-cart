package shopping

import shopping.model.Money
import shopping.model.Product
import shopping.model.ShoppingCart
import shopping.model.ViewProductInCart
import java.util.*


class ShoppingCartService() {

    private var products = listOf<Product>()
    private var coupon: Coupon? = null

    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(productsInCart(), coupon?.name ?: "", format(totalPrice()))
    }

    fun add(product: Product) {
        this.products = this.products + product
    }

    private fun totalPrice(): Money {
        val priceCalculator = PriceCalculator()
        products.forEach { priceCalculator.sum(it.price) }
        Optional.ofNullable(coupon).ifPresent { priceCalculator.applyDiscount(it.discount) }
        return priceCalculator.total()
    }

    private fun productsInCart(): List<ViewProductInCart> {
        return this.products.groupBy { it.name }.map {
            val p = it.value[0]
            ViewProductInCart(p, format(p.price), it.value.size)
        }
    }

    private fun format(money: Money) = String.format(Locale.ENGLISH, "%.2f", money.value)

    fun applyCoupon(coupon: Coupon) {
        this.coupon = coupon
    }

}
