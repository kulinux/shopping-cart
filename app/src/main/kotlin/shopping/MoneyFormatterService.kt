package shopping

import shopping.model.Money
import java.util.*

class MoneyFormatterService {
    fun format(money: Money): String {
        return String.format(Locale.ENGLISH, "%.2f", money.value)
    }

}
