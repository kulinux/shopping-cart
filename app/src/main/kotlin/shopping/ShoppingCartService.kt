package shopping

import shopping.model.Money
import shopping.model.Product
import shopping.model.ViewProductInCart
import shopping.model.ShoppingCart
import java.util.*


class ShoppingCartService() {

    private var products = listOf<Product>()

    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(productsInCart(), totalPrice())
    }

    fun add(product: Product) {
        this.products = this.products + product
    }

    private fun totalPrice(): Money {
        return products.foldRight(Money.Zero) { prod, total -> prod.price + total }
    }


    private fun productsInCart(): List<ViewProductInCart> {
        return this.products.groupBy { it.name }.map {
                val p = it.value[0]
                ViewProductInCart(p, format(p.price), it.value.size)
            }
    }

    private fun format(money: Money) = String.format(Locale.ENGLISH, "%.2f", money.value)

}
