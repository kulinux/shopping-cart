package shopping

enum class Product(val price: Money) {
    Iceberg(Money(2.17)),
    Tomatoe(Money.NoPrice),
    Chicken(Money.NoPrice),
    Bread(Money.NoPrice),
    Corn(Money.NoPrice)
}
