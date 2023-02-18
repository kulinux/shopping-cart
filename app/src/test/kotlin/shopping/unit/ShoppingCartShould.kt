package shopping.unit

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import shopping.Money
import shopping.ShoppingCartService

class ShoppingCartShould:StringSpec( {
    "I want to see my empty shopping cart" {
        val shoppingCart = ShoppingCartService()
        val actual = shoppingCart.getShoppingCart()

        actual.products shouldBe emptyList()
        actual.totalPrice shouldBe Money(0.0)
    }

})
