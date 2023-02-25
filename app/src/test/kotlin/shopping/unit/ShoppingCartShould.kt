package shopping.unit

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainOnly
import io.kotest.matchers.shouldBe
import shopping.ShoppingCartService
import shopping.model.Money
import shopping.model.Product.Iceberg
import shopping.model.ViewProductInCart

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
            actual.products shouldContain ViewProductInCart(Iceberg, "2.17", 1)
        }

        "total price should give sum of product price" {
            val actual = shoppingCart.getShoppingCart()
            actual.totalPrice shouldBe Money(2.17)
        }
    }

    "Same Element In Cart should give one element with quantity 2" {

        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)

        val actual = shoppingCart.getShoppingCart()
        actual.products shouldContainOnly listOf(ViewProductInCart(Iceberg, "2.17", 2))
    }

    "Total product should give the number of element in basket" {

        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)

        val actual = shoppingCart.getShoppingCart()
        actual.totalProduct() shouldBe 2
    }

    "Total price should calculate the price of two elements" {

        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)

        val actual = shoppingCart.getShoppingCart()
        actual.totalPrice shouldBe Money(4.34)
    }

})