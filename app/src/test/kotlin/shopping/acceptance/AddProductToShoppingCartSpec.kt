package shopping.acceptance

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import shopping.Product.*
import shopping.ProductInCart
import shopping.ShoppingCartService

class AddProductToShoppingCartSpec : StringSpec({
    "Add product to shopping cart" {
        val shoppingCart = ShoppingCartService()
        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)
        shoppingCart.add(Tomatoe)
        shoppingCart.add(Chicken)
        shoppingCart.add(Bread)
        shoppingCart.add(Bread)
        shoppingCart.add(Corn)

        val actual = shoppingCart.getShoppingCart()

        actual.products shouldContainExactly
            listOf(
                ProductInCart(Iceberg, "2.17", 3),
                ProductInCart(Tomatoe, "0.73", 1),
                ProductInCart(Chicken, "1,83", 1),
                ProductInCart(Bread, "0.88", 2),
                ProductInCart(Corn, "0.88", 2)
            )

        actual.totalProduct() shouldBe 8
        actual.totalPrice shouldBe "12.33"
    }
})