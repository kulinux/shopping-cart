package shopping.model

data class ShoppingCart(val products: List<ViewProductInCart>, val coupon: String, val totalPrice: String) {
    fun totalProduct(): Int = products.sumOf { it.quantity }
}
