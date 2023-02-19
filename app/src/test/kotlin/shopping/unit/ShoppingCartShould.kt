package shopping.unit

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import shopping.Money
import shopping.Product.Iceberg
import shopping.ProductInCart
import shopping.ShoppingCartService

class ShoppingCartShould : FreeSpec({

    lateinit var shoppingCart: ShoppingCartService

    beforeEach {
        shoppingCart = ShoppingCartService()
    }

    "I want to see my empty shopping cart" {

        val actual = shoppingCart.getShoppingCart()
        actual.products shouldBe emptyList()
        actual.totalPrice shouldBe Money(0.0)
    }

    "Given an element in Cart" - {
        beforeEach {
            shoppingCart.add(Iceberg)
        }

        "products should give this product with price and quantity" {
            val actual = shoppingCart.getShoppingCart()
            actual.products shouldContain ProductInCart(Iceberg, "2.17", 1)
        }
    }

})
