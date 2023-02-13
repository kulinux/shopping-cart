package shopping

class ShoppingCartService {
    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(emptyList(), Money(0.0))
    }

}
