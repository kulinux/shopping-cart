package shopping

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import shopping.model.Money

class MoneyFormatterServiceTest : StringSpec({
    val formatter = MoneyFormatterService()

    "3.17 should format 3.17" {
        formatter.format(Money(3.17)) shouldBe "3.17"
    }

    "1.5 should format 1.50" {
        formatter.format(Money(1.5)) shouldBe "1.50"
    }
})
