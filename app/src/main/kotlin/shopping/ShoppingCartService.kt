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
        val priceCalculator = PriceCalculator()
        products.forEach { priceCalculator.sum(it.price) }
        coupon?.let { priceCalculator.applyDiscount(it.discount) }
        return priceCalculator.total()
    }

}

