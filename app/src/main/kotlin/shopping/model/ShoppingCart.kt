package shopping.model

data class ShoppingCart(val products: List<ProductInCart>, val totalPrice: Money) {
    fun totalProduct(): Int = products.sumOf { it.quantity }
}
