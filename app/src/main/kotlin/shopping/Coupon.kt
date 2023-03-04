package shopping


enum class Coupon(val code: String, val discount: Double) {
    PROMO_5("PROMO_5", 5.0),
    PROMO_10("PROMO_10", 10.0),
}