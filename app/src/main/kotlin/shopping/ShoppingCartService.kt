package shopping

import shopping.model.Money
import shopping.model.Product
import shopping.model.ShoppingCart


class ShoppingCartService() {

    private var products = listOf<Product>()
    private var coupon: Coupon? = null
    private val priceCalculator = PriceCalculator()

    fun getShoppingCart(): ShoppingCart {
        val formatter = ShoppingCartFormatter()
        return formatter.format(products, coupon, totalPrice())
    }

    fun add(product: Product) {
        this.products = this.products + product
    }

    fun applyCoupon(coupon: Coupon) {
        this.coupon = coupon
    }

    private fun totalPrice(): Money {
        return priceCalculator.price(products.map { it.price }, coupon?.discount)
    }

}

