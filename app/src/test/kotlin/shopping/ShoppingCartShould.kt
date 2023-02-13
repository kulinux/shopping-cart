/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package shopping

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ShoppingCartShould:StringSpec( {
    "I want to see my shopping cart" {
        val shoppingCart = ShoppingCartService()
        val actual = shoppingCart.getShoppingCart()

        actual.totalProducts shouldBe emptyList()
        actual.totalPrice shouldBe Money(0.0)
    }
})