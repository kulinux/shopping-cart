package shopping

import shopping.model.Money
import shopping.model.Product
import shopping.model.ProductInCart
import shopping.model.ShoppingCart


class ShoppingCartService(var moneyFormatter: MoneyFormatterService = MoneyFormatterService()) {

    private var products = listOf<ProductInCart>()

    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(products, totalPrice())
    }

    private fun totalPrice(): Money {
        return products
            .map { it.product.price }
            .foldRight(Money.Zero) { total, item -> total + item }
    }


    fun add(product: Product) {
        val existingProduct = this.products.find { it.product.name == product.name }
        val productExcept = this.products.filter { it.product.name != product.name }

        val numberOfExistingProduct = existingProduct?.quantity ?: 0

        this.products =
            productExcept +
                    ProductInCart(
                        product,
                        moneyFormatter.format(product.price),
                        numberOfExistingProduct + 1
                    )
    }

}
