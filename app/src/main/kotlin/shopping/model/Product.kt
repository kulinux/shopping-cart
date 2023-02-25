package shopping.model

enum class Product(val price: Money) {
    Iceberg(Money(2.17)),
    Tomatoe(Money(0.73)),
    Chicken(Money(1.83)),
    Bread(Money(0.88)),
    Corn(Money(1.50))
}
