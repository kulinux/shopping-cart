package shopping

import shopping.model.Money
import shopping.model.Product
import shopping.model.ShoppingCart
import shopping.model.ViewProductInCart
import java.util.*

class ShoppingCartFormatter {
    fun format(products: List<Product>, coupon: Coupon?, totalPrice: Money): ShoppingCart {
        return ShoppingCart(productsInCart(products), coupon?.name ?: "", format(totalPrice))
    }

    private fun productsInCart(products: List<Product>): List<ViewProductInCart> {
        return products.groupBy { it.name }.map {
            val p = it.value[0]
            ViewProductInCart(p, format(p.price), it.value.size)
        }
    }

    private fun format(money: Money) = String.format(Locale.ENGLISH, "%.2f", money.value)

}
