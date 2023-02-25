package shopping.unit

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainOnly
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import shopping.MoneyFormatterService
import shopping.ShoppingCartService
import shopping.model.Money
import shopping.model.Product.Iceberg
import shopping.model.ProductInCart

class ShoppingCartShould : FreeSpec({

    lateinit var moneyFormatter: MoneyFormatterService
    lateinit var shoppingCart: ShoppingCartService

    beforeEach {
        moneyFormatter = mockk<MoneyFormatterService>()
        shoppingCart = ShoppingCartService(moneyFormatter)
    }

    "I want to see my empty shopping cart" {
        val actual = shoppingCart.getShoppingCart()
        actual.products shouldBe emptyList()
        actual.totalPrice shouldBe Money(0.0)
    }

    "Given an element in Cart" - {
        beforeEach {
            every { moneyFormatter.format(Iceberg.price) } returns "2.17"
            shoppingCart.add(Iceberg)
        }

        "products should give this product with price and quantity" {
            val actual = shoppingCart.getShoppingCart()
            actual.products shouldContain ProductInCart(Iceberg, "2.17", 1)
        }

        "total price should give sum of product price" {
            val actual = shoppingCart.getShoppingCart()
            actual.totalPrice shouldBe Money(2.17)
        }
    }

    "Same Element In Cart should give one element with quantity 2" {
        every { moneyFormatter.format(Iceberg.price) } returns "2.17"

        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)

        val actual = shoppingCart.getShoppingCart()
        actual.products shouldContainOnly listOf(ProductInCart(Iceberg, "2.17", 2))
    }

})
