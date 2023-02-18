package shopping

class ShoppingCartService {
    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(emptyList(), Money(0.0))
    }

    fun add(iceberg: Product) {
        TODO("Not Implemented")
    }

}
