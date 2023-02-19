package shopping

class ShoppingCartService {

    private var products = listOf<ProductInCart>()

    fun getShoppingCart(): ShoppingCart {
        return ShoppingCart(products, Money(0.0))
    }

    fun add(product: Product) {
        this.products += ProductInCart(product, product.price.value.toString(), 1)
    }

}
