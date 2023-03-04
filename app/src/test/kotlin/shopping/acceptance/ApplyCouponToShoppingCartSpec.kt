package shopping.acceptance

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import shopping.Coupon
import shopping.model.Product.*
import shopping.model.ViewProductInCart
import shopping.ShoppingCartService
import shopping.model.Money

class ApplyCouponToShoppingCartSpec : StringSpec({
    "Apply discount to the shopping cart" {
        val shoppingCart = ShoppingCartService()

        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)
        shoppingCart.add(Iceberg)
        shoppingCart.add(Tomatoe)
        shoppingCart.add(Chicken)
        shoppingCart.add(Bread)
        shoppingCart.add(Bread)
        shoppingCart.add(Corn)
        shoppingCart.applyCoupon(Coupon.PROMO_5)

        val actual = shoppingCart.getShoppingCart()

        actual.products shouldContainExactly
            listOf(
                ViewProductInCart(Iceberg, "2.17", 3),
                ViewProductInCart(Tomatoe, "0.73", 1),
                ViewProductInCart(Chicken, "1.83", 1),
                ViewProductInCart(Bread, "0.88", 2),
                ViewProductInCart(Corn, "1.50", 1)
            )

        actual.coupon shouldBe "PROMO_5"
        actual.totalProduct() shouldBe 8
        actual.totalPrice shouldBe "11.71"
    }
})